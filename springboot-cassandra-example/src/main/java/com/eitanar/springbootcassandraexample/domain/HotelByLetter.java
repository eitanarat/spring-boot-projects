package com.eitanar.springbootcassandraexample.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("hotels_by_letter")
public class HotelByLetter {

    @PrimaryKey
    private HotelByLetterKey hotelByLetterKey;
    private String address;
    private String state;
    private String zip;

    public HotelByLetter() {
    }

    public HotelByLetter(Hotel hotel) {
        HotelByLetterKey hotelByLetterKey = new HotelByLetterKey();
        hotelByLetterKey.setFirstLetter(hotel.getName().substring(0, 1));
        hotelByLetterKey.setHotelName(hotel.getName());
        hotelByLetterKey.setHotelId(hotel.getId());
        this.setHotelByLetterKey(hotelByLetterKey);
        this.setState(hotel.getState());
        this.setAddress(hotel.getAddress());
        this.setZip(hotel.getZip());
    }

    public HotelByLetterKey getHotelByLetterKey() {
        return hotelByLetterKey;
    }

    public void setHotelByLetterKey(HotelByLetterKey hotelByLetterKey) {
        this.hotelByLetterKey = hotelByLetterKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

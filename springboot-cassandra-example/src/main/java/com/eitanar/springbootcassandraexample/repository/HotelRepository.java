package com.eitanar.springbootcassandraexample.repository;


import com.eitanar.springbootcassandraexample.domain.Hotel;

import java.util.List;
import java.util.UUID;

public interface HotelRepository {

    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    Hotel findOne(UUID hotelId);
    void delete(UUID hotelId);
    List<Hotel> findByState(String state);

}

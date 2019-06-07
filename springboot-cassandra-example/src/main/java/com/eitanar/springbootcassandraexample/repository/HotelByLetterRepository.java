package com.eitanar.springbootcassandraexample.repository;

import com.eitanar.springbootcassandraexample.domain.HotelByLetter;
import com.eitanar.springbootcassandraexample.domain.HotelByLetterKey;

import java.util.List;

public interface HotelByLetterRepository {

    List<HotelByLetter> findByFirstLetter(String letter);
    HotelByLetter save(HotelByLetter hotelByLetter);
    void delete(HotelByLetterKey hotelByLetterKey);
}

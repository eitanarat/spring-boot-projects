package com.eitanar.springbootcassandraexample.service;

import com.eitanar.springbootcassandraexample.domain.Hotel;
import com.eitanar.springbootcassandraexample.domain.HotelByLetter;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    Hotel findOne(UUID uuid);
    void delete(UUID uuid);

    List<HotelByLetter> findHotelsStartingWith(String letter);
    List<Hotel> findHotelInState(String state);
}

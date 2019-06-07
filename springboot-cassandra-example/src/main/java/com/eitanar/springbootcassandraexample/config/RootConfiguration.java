package com.eitanar.springbootcassandraexample.config;

import com.eitanar.springbootcassandraexample.repository.HotelByLetterRepository;
import com.eitanar.springbootcassandraexample.repository.HotelRepository;
import com.eitanar.springbootcassandraexample.service.HotelService;
import com.eitanar.springbootcassandraexample.service.HotelServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfiguration {

    @Bean
    public HotelService hotelService(HotelRepository hotelRepository, HotelByLetterRepository hotelByLetterRepository)  {
        return new HotelServiceImpl(hotelRepository, hotelByLetterRepository);
    }

}

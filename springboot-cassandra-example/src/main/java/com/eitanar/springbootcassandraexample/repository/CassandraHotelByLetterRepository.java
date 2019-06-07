package com.eitanar.springbootcassandraexample.repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.eitanar.springbootcassandraexample.domain.HotelByLetter;
import com.eitanar.springbootcassandraexample.domain.HotelByLetterKey;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CassandraHotelByLetterRepository implements HotelByLetterRepository {

    private final CassandraOperations cassandraOperations;

    public CassandraHotelByLetterRepository(CassandraOperations cassandraOperations) {
        this.cassandraOperations = cassandraOperations;
    }

    @Override
    public List<HotelByLetter> findByFirstLetter(String letter) {
        Select selectQuery = QueryBuilder.select().from("hotels_by_letter");
        selectQuery.where(QueryBuilder.eq("first_letter", letter));

        return this.cassandraOperations.select(selectQuery, HotelByLetter.class);
    }

    @Override
    public HotelByLetter save(HotelByLetter hotelByLetter) {
        return this.cassandraOperations.insert(hotelByLetter);
    }

    @Override
    public void delete(HotelByLetterKey hotelByLetterKey) {
        this.cassandraOperations.deleteById(hotelByLetterKey, HotelByLetterKey.class);
    }
}

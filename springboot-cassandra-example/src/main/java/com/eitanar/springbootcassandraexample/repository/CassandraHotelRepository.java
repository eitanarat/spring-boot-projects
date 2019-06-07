package com.eitanar.springbootcassandraexample.repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.eitanar.springbootcassandraexample.domain.Hotel;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CassandraHotelRepository implements HotelRepository    {

    private final CassandraOperations cassandraOperations;

    public CassandraHotelRepository(CassandraOperations cassandraOperations) {
        this.cassandraOperations = cassandraOperations;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return this.cassandraOperations.insert(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return this.cassandraOperations.update(hotel);
    }

    @Override
    public Hotel findOne(UUID hotelId) {

        return this.cassandraOperations.selectOneById(hotelId, Hotel.class);
    }

    @Override
    public void delete(UUID hotelId) {
        this.cassandraOperations.delete(hotelId);

    }

    @Override
    public List<Hotel> findByState(String state) {
        Select select = QueryBuilder.select().from("hotels_by_state");
        select.where(QueryBuilder.eq("state", state));

        return this.cassandraOperations.select(select, Hotel.class);
    }
}

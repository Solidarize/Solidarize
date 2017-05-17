package com.solidarize.repository;

import com.solidarize.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    Event findById(Integer id);
}

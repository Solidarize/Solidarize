package com.solidarize.repository;

import com.solidarize.model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    Event findEventById(Integer id);

    List<Event> findAllByOrderByTimestampDesc(Pageable pageable);

    List<Event> findAllByOrderByTimestampAsc(Pageable pageable);

    List<Event> findAllByOrderByRankDesc(Pageable pageable);

    List<Event> findAllByOrderByRankAsc(Pageable pageable);
}
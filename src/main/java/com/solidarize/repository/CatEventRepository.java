package com.solidarize.repository;


import com.solidarize.model.CatEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatEventRepository extends CrudRepository<CatEvent, Integer>{
    CatEvent findCatEvent(CatEvent catevent);
}

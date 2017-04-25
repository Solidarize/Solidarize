package com.solidarize.repository;

import com.solidarize.model.Institution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution, Integer>{
    Institution findInstitutionById(Integer id);
}

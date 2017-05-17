package com.solidarize.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solidarize.model.Institution;

@Repository
public interface InstitutionRepository  extends CrudRepository<Institution, Integer>{
	Institution findById(Integer id);
	Institution findByCnpjAndPassword(String cnpj, String password);
}

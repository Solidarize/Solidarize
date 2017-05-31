package com.solidarize.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solidarize.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(Integer id);
	User findByLogin(String Login);
}

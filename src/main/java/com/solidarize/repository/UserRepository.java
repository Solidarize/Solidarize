package com.solidarize.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solidarize.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(BigInteger id);
	User findByLogin(String Login);
}

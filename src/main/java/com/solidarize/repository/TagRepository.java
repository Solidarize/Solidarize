package com.solidarize.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solidarize.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{
		Tag findById(BigInteger id);
		List<Tag> findByIdentifier(Integer identifier);
		List<Tag> findByTagname(String tagname);
}

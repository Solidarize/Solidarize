package com.solidarize.repository;


import com.solidarize.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
    Category findCategoryById(Integer id);
}


package com.solidarize.service;

import com.solidarize.model.Category;
import com.solidarize.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryService {
 private CategoryRepository categoryRepository;
    
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
     public Category getCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public Iterable<Category> readCategorys(){
      return categoryRepository.findAll();
    }
    
    public boolean deleteCategory(Category category){
        try{
           categoryRepository.delete(category);
           return true;
        }catch(Exception Ex){
           return false; 
        }
    }
    
    public Category findCategory(Category category){
        return categoryRepository.findOne(category.getId());
    }        
       
}

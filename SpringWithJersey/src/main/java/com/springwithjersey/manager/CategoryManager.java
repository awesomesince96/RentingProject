package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.Category;
import com.springwithjersey.rest.data.CategoryRepository;

@Service
public class CategoryManager {

  private @Autowired CategoryRepository categoryRepository;

  public void createCategory(Category category) {
    categoryRepository.save(category);
  }


  public Category getCategoryById(long id) {
    return categoryRepository.findById(id);
  }

  public List<Category> getCategory() {
    // return categoryRepository.findAllByStatus(Status.ACTIVE);
    return categoryRepository.findAll();
  }

  public void saveAllCategory(List<Category> category) {
    categoryRepository.save(category);
  }

  public void deleteCategory(long id) {
    long result = categoryRepository.deleteById(id);
    System.out.println("----" + result);
  }

}

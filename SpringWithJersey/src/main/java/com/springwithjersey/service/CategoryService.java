package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.CategoryManager;
import com.springwithjersey.model.Category;

@Service
@Transactional
public class CategoryService {

  private @Autowired CategoryManager categoryManager;

  public void createCategory(Category category) {
    categoryManager.createCategory(category);
  }

  public Category getCategoryById(long id) {
    Category category = categoryManager.getCategoryById(id);
    return category;
  }

  public List<Category> getCategory() {
    List<Category> category = categoryManager.getCategory();
    return category;
  }

  public void saveAllCategory(List<Category> category) {
    categoryManager.saveAllCategory(category);
  }

  public void deleteCategory(long id) {
    categoryManager.deleteCategory(id);
  }

}

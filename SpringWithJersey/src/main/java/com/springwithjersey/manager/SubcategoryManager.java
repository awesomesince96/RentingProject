package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.Category;
import com.springwithjersey.model.SubCategory;
import com.springwithjersey.rest.data.SubCategoryRepository;

@Service
public class SubcategoryManager {

  private @Autowired SubCategoryRepository subcategoryRepository;

  public void createSubcategory(SubCategory subcategory) {
    subcategoryRepository.save(subcategory);
  }

  public SubCategory getSubcategoryById(long id) {
    return subcategoryRepository.findById(id);
  }

  public List<SubCategory> getSubcategory() {
    // return subcategoryRepository.findAllByStatus(Status.ACTIVE);
    return subcategoryRepository.findAll();
  }

  public List<SubCategory> getSubcategoryByCategory(Category category) {
    return subcategoryRepository.findAllByCategory(category);
  }
  //
  // public List<SubCategory> getSubcategoryByCity(City city) {
  // return subcategoryRepository.findAllByCity(city);
  //
  // }

  public void saveAllSubcategory(List<SubCategory> subcategorys) {
    subcategoryRepository.save(subcategorys);
  }

  public void deleteSubcategory(long id) {
    long result = subcategoryRepository.deleteById(id);

    System.out.println("----" + result);
  }

  // public void deleteSubcategoryCity(long sid, long cid) {
  // SubCategory subcategory = new SubCategory();
  // }

}

package com.springwithjersey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.SubcategoryManager;
import com.springwithjersey.model.Category;
import com.springwithjersey.model.City;
import com.springwithjersey.model.City_Subcategory;
import com.springwithjersey.model.SubCategory;
import com.springwithjersey.rest.data.CitySubcategoryRepository;

@Service
@Transactional
public class SubCategoryService {

  private @Autowired SubcategoryManager subcategorymanager;
  private @Autowired CitySubcategoryRepository cscRepo;

  public void createSubcategory(SubCategory subcategory) {
    subcategorymanager.createSubcategory(subcategory);
  }

  public SubCategory getSubcategoryById(long id) {
    SubCategory subcategory = subcategorymanager.getSubcategoryById(id);
    return subcategory;
  }

  public List<SubCategory> getSubcategory() {
    List<SubCategory> subcategory = subcategorymanager.getSubcategory();
    return subcategory;
  }

  public List<SubCategory> getSubcategoryByCategory(long id) {
    Category category = new Category();
    category.setId(id);
    List<SubCategory> subcategory_res = subcategorymanager.getSubcategoryByCategory(category);
    return subcategory_res;
  }

  public List<SubCategory> getSubcategoryByCity(long id) {
    City city = new City();
    city.setId(id);
    List<City_Subcategory> csc = cscRepo.findByCity(city);
    List<SubCategory> subcat = new ArrayList<>();
    for (int i = 0; i < csc.size(); i++) {
      subcat.add(csc.get(i).getSubcategory());
    }
    // City city = new City();
    // city.setId(id);
    // List<SubCategory> subcategory_res = subcategorymanager.getSubcategoryByCity(city);
    return subcat;
  }

  public void saveAllSubcategory(List<SubCategory> countries) {
    subcategorymanager.saveAllSubcategory(countries);
  }

  public void deleteSubcategory(long cid, long sid) {
    City city = new City();
    SubCategory subcat = new SubCategory();
    city.setId(cid);
    subcat.setId(sid);
    cscRepo.deleteByCityAndSubcategory(city, subcat);
  }

  public void saveSubcategoryByCity(long cid, long sid) {
    City_Subcategory city_Subcategory = new City_Subcategory();
    City city = new City();
    SubCategory subcat = new SubCategory();
    city.setId(cid);
    subcat.setId(sid);
    city_Subcategory.setCity(city);
    city_Subcategory.setSubcategory(subcat);
    cscRepo.save(city_Subcategory);
  }

  // public void deleteSubcategoryCity(long sid, long cid) {
  // subcategorymanager.deleteSubcategoryCity(sid, cid);
  // }
}

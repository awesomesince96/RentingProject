package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.CountryManager;
import com.springwithjersey.model.Country;


@Service
@Transactional
public class CountryService {

  private @Autowired CountryManager countrymanager;

  public void createCountry(Country country) {
    countrymanager.createCountry(country);
  }

  public Country getCountryById(long id) {
    return countrymanager.getCountryById(id);
  }

  public List<Country> getCountry() {
    return countrymanager.getCountry();
  }

  public void updateCountry(Country country) {
    String name = country.getName();
    long id = country.getId();
    countrymanager.updateCountry(name, id);
  }

  public void deleteCountry(long id) {
    countrymanager.deleteCountry(id);
  }

  public void saveAllCountry(List<Country> countries) {
    countrymanager.saveAllCountry(countries);
  }



}



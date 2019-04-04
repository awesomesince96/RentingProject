package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.Country;
import com.springwithjersey.rest.data.CountryRepository;

@Service
public class CountryManager {

  private @Autowired CountryRepository countryRepository;

  public void createCountry(Country country) {
    countryRepository.save(country);
  }

  public Country getCountryById(long id) {
    return countryRepository.findById(id);
  }

  public List<Country> getCountry() {
    return countryRepository.findAllByStatus(Status.ACTIVE);
  }

  public void updateCountry(String name, long id) {
    int result = countryRepository.updateCountryNameById(name, id);
  }

  public void deleteCountry(long id) {
    long result = countryRepository.deleteById(id);
    System.out.println("--------" + result);
  }

  public void saveAllCountry(List<Country> countries) {
    countryRepository.save(countries);
  }

}

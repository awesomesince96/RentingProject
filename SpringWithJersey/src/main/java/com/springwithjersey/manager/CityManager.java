package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.City;
import com.springwithjersey.model.State;
import com.springwithjersey.rest.data.CityRepository;

@Service
public class CityManager {

  private @Autowired CityRepository cityRepository;

  public void createCity(City city) {
    cityRepository.save(city);
  }

  public City getCityById(long id) {
    return cityRepository.findById(id);
  }

  public List<City> getCity() {
    return cityRepository.findAll();
  }

  public List<City> getCityByState(State state) {
    return cityRepository.findAllByState(state);
  }

  public void saveAllCity(List<City> citys) {
    cityRepository.save(citys);
  }

  public void deleteCity(long id) {
    long result = cityRepository.deleteById(id);
    System.out.println("----" + result);
  }
}

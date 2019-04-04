package com.springwithjersey.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.CityManager;
import com.springwithjersey.model.City;
import com.springwithjersey.model.State;
import com.springwithjersey.requestdto.CityDto;
import com.springwithjersey.rest.helper.CityHelper;

@Service
@Transactional
public class CityService {

  private @Autowired CityManager citymanager;
  private @Autowired CityHelper cityhelper;

  // public void createCity(CityDto citydto) {
  // citymanager.createCity(cityhelper.BuildCity(citydto));
  // }

  public void createCity(City city) {
    citymanager.createCity(city);
  }

  public City getCityById(long id) {
    City city = citymanager.getCityById(id);

    // ----> Option 1
    // CityDto citydto = new CityDto(city);
    // return citydto;

    // -----> Option 2
    CityDto cityDTO = cityhelper.BuildCityDto(city);

    return city;
  }

  public List<City> getCity() throws IllegalAccessException, InvocationTargetException {
    List<City> city = citymanager.getCity();
    // List<CityDto> citydto = new ArrayList<CityDto>();
    // for (City cityy : city) {
    // CityDto citydto1 = new CityDto(cityy);
    // citydto.add(citydto1);
    // }
    return city;
  }

  public List<CityDto> getCityByState(long id) {
    State state = new State();
    state.setId(id);
    List<City> city = citymanager.getCityByState(state);
    // List<City> city = citymanager.getCity();
    List<CityDto> citydto = new ArrayList<CityDto>();
    for (City cityy : city) {
      CityDto citydto1 = new CityDto(cityy);
      citydto.add(citydto1);
    }
    return citydto;
    // return (List<CityDto>) city;
  }

  public void saveAllCity(List<City> countries) {
    citymanager.saveAllCity(countries);
  }

  public void deleteCity(long id) {
    citymanager.deleteCity(id);
  }


}



// System.out.println("B--->" + city);
// System.out.println("B--->" + citydto);
// BeanUtils.copyProperties(city, citydto);
// System.out.println("A--->" + city);
// System.out.println("A--->" + citydto);
// return cityhelper.BuildCityDto(city);

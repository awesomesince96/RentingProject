package com.springwithjersey.requestdto;

import com.springwithjersey.model.City;
import com.springwithjersey.model.User;

public class NewUserDto {

  private User user;
  private City city;

  public NewUserDto() {
    super();
  }

  public NewUserDto(User user, City city) {
    super();
    this.user = user;
    this.city = city;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

}

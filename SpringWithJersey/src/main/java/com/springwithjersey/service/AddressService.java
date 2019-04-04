package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.AddressManager;
import com.springwithjersey.model.Address;
import com.springwithjersey.model.City;
import com.springwithjersey.model.User;

@Service
@Transactional
public class AddressService {

  private @Autowired AddressManager addressManager;

  public void createAddress(Address address) {
    addressManager.createAddress(address);
  }

  public Address getAddressById(long id) {
    Address address = addressManager.getAddressById(id);
    return address;
  }

  public List<Address> getAddress() {
    List<Address> address = addressManager.getAddress();
    return address;
  }

  public List<User> getAddressByUser(long id) {
    User user = new User();
    user.setId(id);
    List<User> user_res = addressManager.getAddressByUser(user);
    return user_res;
  }

  public List<Address> getAddressByCity(long id) {
    City city = new City();
    city.setId(id);
    List<Address> address_res = addressManager.getAddressByCity(city);
    return address_res;
  }

  public void saveAllAddress(List<Address> countries) {
    addressManager.saveAllAddress(countries);
  }

  public void deleteAddress(long id) {
    addressManager.deleteAddress(id);
  }

}

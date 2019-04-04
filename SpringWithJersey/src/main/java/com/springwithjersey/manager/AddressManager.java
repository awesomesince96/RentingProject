package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.Address;
import com.springwithjersey.model.City;
import com.springwithjersey.model.User;
import com.springwithjersey.rest.data.AddressRepository;

@Service
public class AddressManager {

  private @Autowired AddressRepository addressRepository;

  public void createAddress(Address address) {
    addressRepository.save(address);
  }

  public Address getAddressById(long id) {
    return addressRepository.findById(id);
  }

  public List<Address> getAddress() {
    System.out.println("---->>" + addressRepository.findAllByStatus(Status.ACTIVE));
    return addressRepository.findAllByStatus(Status.ACTIVE);
  }

  public List<User> getAddressByUser(User user) {
    return addressRepository.findAllByUser(user);
  }

  public List<Address> getAddressByCity(City city) {
    return addressRepository.findAllByCity(city);
  }

  public void saveAllAddress(List<Address> address) {
    addressRepository.save(address);
  }

  public void deleteAddress(long id) {
    long result = addressRepository.deleteById(id);
  }
}

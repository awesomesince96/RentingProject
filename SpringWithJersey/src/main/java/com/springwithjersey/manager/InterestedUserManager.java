package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.InterestedUser;
import com.springwithjersey.model.Item;
import com.springwithjersey.model.User;
import com.springwithjersey.rest.data.InterestedUserRepository;

@Service
public class InterestedUserManager {

  private @Autowired InterestedUserRepository interestedUserRepository;

  public void createInterestedUser(InterestedUser interesteduser) {
    interestedUserRepository.save(interesteduser);
  }

  public InterestedUser getInterestedUserById(long id) {
    return interestedUserRepository.findById(id);
  }

  public List<InterestedUser> getInterestedUser() {
    return interestedUserRepository.findAll();
  }

  public List<User> getInterestedUserByUser(User user) {
    return interestedUserRepository.findAllByUser(user);
  }

  public List<InterestedUser> getInterestedUserByItem(Item item) {
    return interestedUserRepository.findAllByItem(item);
  }

  public void saveAllInterestedUser(List<InterestedUser> interesteduser) {
    interestedUserRepository.save(interesteduser);
  }

  public void deleteInterestedUser(long id) {
    long result = interestedUserRepository.deleteById(id);
  }
}

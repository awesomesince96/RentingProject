package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.common.util.Status;
import com.springwithjersey.model.User;
import com.springwithjersey.rest.data.UserRepository;

@Service
public class UserManager {

  private @Autowired UserRepository userRepository;

  public void createUser(User user) {
    userRepository.save(user);
  }

  public User getUserById(long id) {
    return userRepository.findById(id);
  }

  public List<User> getUser() {
    return userRepository.findAllByStatus(Status.ACTIVE);
  }

  public void deleteUser(long id) {
    long result = userRepository.deleteById(id);
  }

  public void saveAllUser(List<User> countries) {
    userRepository.save(countries);
  }
}

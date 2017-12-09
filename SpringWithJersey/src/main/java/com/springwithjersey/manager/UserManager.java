package com.springwithjersey.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.User;
import com.springwithjersey.rest.data.UserRepository;

@Service
public class UserManager {
  private @Autowired UserRepository userRepository;

  public User findByUserName(String name, boolean validate) {
    User user = userRepository.findByEmail(name);
    return user;
  }

  public User findByUserEmail(String name, boolean validate) {
    User user = userRepository.findByEmail(name);
    return user;
  }

  public User findByUserEmail(String name) {
    return userRepository.findByEmail(name);
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User findById(Long id) {
    return findById(id, true);
  }

  public User findById(Long id, boolean validate) {
    User user = userRepository.findOne(id);
    return user;
  }

}

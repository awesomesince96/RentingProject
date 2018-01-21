package com.springwithjersey.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.rest.data.UserRepository;

@Service
public class UserManager {

  @Autowired
  UserRepository userrepo;

  public void getCityName() {

  }
}

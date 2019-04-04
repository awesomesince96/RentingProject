package com.springwithjersey.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwithjersey.model.User;
import com.springwithjersey.model.UserCart;
import com.springwithjersey.rest.data.UserCartRepository;

@Service
public class UserCartManager {

  private @Autowired UserCartRepository userCartRepository;

  public void createUserCart(UserCart userCart) {
    userCartRepository.save(userCart);
  }

  public UserCart getUserCartById(long id) {
    return userCartRepository.findById(id);
  }

  public List<UserCart> getUserCart() {
    return userCartRepository.findAll();
  }

  public List<User> getUserCartByUser(User user) {
    return userCartRepository.findAllByUser(user);
  }

  public void saveAllUserCart(List<UserCart> userCart) {
    userCartRepository.save(userCart);
  }

  public void deleteUserCart(long id) {
    long result = userCartRepository.deleteById(id);
  }

}

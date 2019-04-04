package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.UserCartManager;
import com.springwithjersey.model.User;
import com.springwithjersey.model.UserCart;

@Service
@Transactional
public class UserCartService {

  private @Autowired UserCartManager userCartManager;

  public void createUserCart(UserCart userCart) {
    userCartManager.createUserCart(userCart);
  }

  public UserCart getUserCartById(long id) {
    UserCart userCart = userCartManager.getUserCartById(id);
    return userCart;
  }

  public List<UserCart> getUserCart() {
    List<UserCart> userCart = userCartManager.getUserCart();
    return userCart;
  }

  public List<User> getUserCartByUser(long id) {
    User user = new User();
    user.setId(id);
    List<User> user_res = userCartManager.getUserCartByUser(user);
    return user_res;
  }

  public void saveAllUserCart(List<UserCart> countries) {
    userCartManager.saveAllUserCart(countries);
  }

  public void deleteUserCart(long id) {
    userCartManager.deleteUserCart(id);
  }

}

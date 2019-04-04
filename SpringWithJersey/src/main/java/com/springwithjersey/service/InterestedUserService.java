package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.InterestedUserManager;
import com.springwithjersey.model.InterestedUser;
import com.springwithjersey.model.Item;
import com.springwithjersey.model.User;

@Service
@Transactional
public class InterestedUserService {

  private @Autowired InterestedUserManager interesteduserManager;

  public void createInterestedUser(InterestedUser interesteduser) {
    interesteduserManager.createInterestedUser(interesteduser);
  }

  public InterestedUser getInterestedUserById(long id) {
    InterestedUser interesteduser = interesteduserManager.getInterestedUserById(id);
    return interesteduser;
  }

  public List<InterestedUser> getInterestedUser() {
    List<InterestedUser> interesteduser = interesteduserManager.getInterestedUser();
    return interesteduser;
  }

  public List<User> getInterestedUserByUser(long id) {
    User user = new User();
    user.setId(id);
    List<User> user_res = interesteduserManager.getInterestedUserByUser(user);
    return user_res;
  }

  public List<InterestedUser> getInterestedUserByItem(long id) {
    Item item = new Item();
    item.setId(id);
    List<InterestedUser> interesteduser_res = interesteduserManager.getInterestedUserByItem(item);
    return interesteduser_res;
  }

  public void saveAllInterestedUser(List<InterestedUser> countries) {
    interesteduserManager.saveAllInterestedUser(countries);
  }

  public void deleteInterestedUser(long id) {
    interesteduserManager.deleteInterestedUser(id);
  }

}

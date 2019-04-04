package com.springwithjersey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.manager.UserManager;
import com.springwithjersey.model.User;

@Service
@Transactional
public class UserService {

  private @Autowired UserManager Usermanager;

  public void createUser(User User) {
    Usermanager.createUser(User);
  }

  public User getUserById(long id) {
    return Usermanager.getUserById(id);
  }

  public List<User> getUser() {
    return Usermanager.getUser();
  }

  public void deleteUser(long id) {
    Usermanager.deleteUser(id);
  }

  public void saveAllUser(List<User> countries) {
    Usermanager.saveAllUser(countries);
  }

}



// package com.springwithjersey.service;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.springwithjersey.common.util.PasswordUtils;
// import com.springwithjersey.manager.UserManager;
// import com.springwithjersey.model.User;
// import com.springwithjersey.requestdto.UpdateUserInformationDto;
// import com.springwithjersey.requestdto.UserInformationDto;
// import com.springwithjersey.requestdto.UserRegistrationDto;
// import com.springwithjersey.rest.helper.UserHelper;
//
//
// @Service
// @Transactional
// public class UserService {
// private @Autowired UserManager userManager;
// private @Autowired UserHelper userHelper;
// private @Autowired PasswordEncoder passwordEncoder;
//
//
// public UserInformationDto getUserProfile(String name) {
// User user = userManager.findByUserName(name, true);
// UserInformationDto userInformation = userHelper.buildSuperAdminUserInformation(user);
// return userInformation;
// }
//
// public UserRegistrationDto register(UserRegistrationDto userRegister) {
// userManager.findByUserEmail(userRegister.getSubscriber().getEmail(), true);
// try {
// // byte[] profileImage =
// // checkAndAssignFileContents(userRegister.getUserProfilePictureInformation().getProfilePic());
// User user = userHelper.buildUser(userRegister, null);
// String password = PasswordUtils.generatePassword();
// System.out.println("password = " + password);
// user.setPassword(buildEncryptPassword(password));
// userManager.save(user);
//
// return new UserRegistrationDto(userHelper.buildSubscriberInformation(user));
// } catch (Exception e) {
// System.out.println("abacd");
// }
// return userRegister;
// }
//
// public byte[] checkAndAssignFileContents(String profilePicture) {
// return profilePicture != null ? profilePicture.getBytes() : null;
// }
//
// public String buildEncryptPassword(String password) {
// return passwordEncoder.encode(password);
//
// }
//
// public UpdateUserInformationDto updateUser(UpdateUserInformationDto updateUserInformation, Long userId) {
// User user = userManager.findById(userId, true);
// user = userHelper.setUserInformation(user, updateUserInformation);
// userManager.save(user);
//
// return userHelper.buildUpdateUserInformation(user);
// }
//
// }
//
//

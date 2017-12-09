package com.springwithjersey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springwithjersey.common.util.PasswordUtils;
import com.springwithjersey.manager.UserManager;
import com.springwithjersey.model.User;
import com.springwithjersey.requestdto.UpdateUserInformationDto;
import com.springwithjersey.requestdto.UserInformationDto;
import com.springwithjersey.requestdto.UserRegistrationDto;
import com.springwithjersey.rest.helper.UserHelper;


@Service
@Transactional
public class UserService {
  private @Autowired UserManager userManager;
  private @Autowired UserHelper userHelper;
  private @Autowired PasswordEncoder passwordEncoder;

  public UserInformationDto getUserProfile(String name) {
    User user = userManager.findByUserName(name, true);
    UserInformationDto userInformation = userHelper.buildSuperAdminUserInformation(user);

    return userInformation;
  }

  public UserRegistrationDto register(UserRegistrationDto userRegister) {
    userManager.findByUserEmail(userRegister.getSubscriber().getEmail(), true);
    try {
      byte[] profileImage = checkAndAssignFileContents(userRegister.getUserProfilePictureInformation().getProfilePic());
      User user = userHelper.buildUser(userRegister, profileImage);
      String password = PasswordUtils.generatePassword();
      System.out.println("password = " + password);
      user.setPassword(buildEncryptPassword(password));
      userManager.save(user);

      return new UserRegistrationDto(userHelper.buildSubscriberInformation(user));
    } catch (Exception e) {
      System.out.println("abacd");
    }
    return userRegister;
  }

  public byte[] checkAndAssignFileContents(String profilePicture) {
    return profilePicture != null ? profilePicture.getBytes() : null;
  }

  public String buildEncryptPassword(String password) {
    return passwordEncoder.encode(password);

  }

  public UpdateUserInformationDto updateUser(UpdateUserInformationDto updateUserInformation, Long userId) {
    User user = userManager.findById(userId, true);
    user = userHelper.setUserInformation(user, updateUserInformation);
    userManager.save(user);

    return userHelper.buildUpdateUserInformation(user);
  }

}



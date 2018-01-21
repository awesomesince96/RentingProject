// package com.springwithjersey.rest.helper;
//
// import java.util.UUID;
//
// import org.springframework.stereotype.Component;
//
// import com.springwithjersey.model.Role;
// import com.springwithjersey.model.User;
// import com.springwithjersey.requestdto.SubscriberInformationDto;
// import com.springwithjersey.requestdto.UpdateUserInformationDto;
// import com.springwithjersey.requestdto.UserInformationDto;
// import com.springwithjersey.requestdto.UserRegistrationDto;
// import com.springwithjersey.rest.constants.StatusConstants;
//
// @Component
// public class UserHelper {
//
//
// public UserInformationDto buildSuperAdminUserInformation(User user) {
// UserInformationDto userInformation = new UserInformationDto();
// // Long userid = Long.valueOf();
// userInformation.setId(user.getId());
// userInformation.setFirstName(user.getFirstName());
// userInformation.setLastName(user.getLastName());
// userInformation.setEmail(user.getEmail());
// userInformation.setContactNumber(user.getContactNumber());
// userInformation.setStatus(user.getStatus());
// // userInformation.setProfilePic(user.getProfilePic() != null ? (new String(user.getProfilePic())) : null);
//
// return userInformation;
// }
//
// public SubscriberInformationDto buildSubscriberInformation(User user) {
// SubscriberInformationDto subscriberInformation = new SubscriberInformationDto();
// subscriberInformation.setId(user.getId());
// subscriberInformation.setFirstName(user.getFirstName());
// subscriberInformation.setLastName(user.getLastName());
// subscriberInformation.setEmail(user.getEmail());
// subscriberInformation.setContactNumber(user.getContactNumber());
// subscriberInformation.setRoleId(user.getRole().getId());
// subscriberInformation.setStatus(user.getStatus());
//
// return subscriberInformation;
// }
//
// public User buildUser(UserRegistrationDto userRegistration, byte[] profileImage) {
// User user = new User();
// user.setUuid(getUUID());
// user.setFirstName(userRegistration.getSubscriber().getFirstName());
// user.setLastName(userRegistration.getSubscriber().getLastName());
// user.setEmail(userRegistration.getSubscriber().getEmail());
// user.setContactNumber(userRegistration.getSubscriber().getContactNumber());
// user.setProfilePic(profileImage);
// user.setPassword(userRegistration.getSubscriber().getPassword());
// Role role = new Role();
// role.setId(1L);
// role.setName("Super Admin");;
// user.setRole(role);
// user.setStatus(StatusConstants.ACTIVE);
//
// return user;
// }
//
// public static String getUUID() {
// return UUID.randomUUID().toString().replace("-", "");
// }
//
// public User setUserInformation(User user, UpdateUserInformationDto updateUserInformation) {
// user.setFirstName(updateUserInformation.getFirstName());
// user.setLastName(updateUserInformation.getLastName());
// user.setContactNumber(updateUserInformation.getContactNumber());
//
// return user;
// }
//
// public UpdateUserInformationDto buildUpdateUserInformation(User user) {
// UpdateUserInformationDto updateUserInformation = new UpdateUserInformationDto();
// updateUserInformation.setFirstName(user.getFirstName());
// updateUserInformation.setLastName(user.getLastName());
// updateUserInformation.setContactNumber(user.getContactNumber());
// updateUserInformation.setEmail(user.getEmail());
// updateUserInformation.setId(user.getId());
//
// return updateUserInformation;
// }
// }

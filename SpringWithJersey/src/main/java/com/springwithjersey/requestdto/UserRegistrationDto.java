package com.springwithjersey.requestdto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserRegistrationDto {

  private SubscriberInformationDto subscriber;
  private UserProfilePictureInformationDto userProfilePictureInformation;


  public UserRegistrationDto() {

  }

  public UserRegistrationDto(SubscriberInformationDto subscriberInformationDto) {
    this.subscriber = subscriberInformationDto;
  }

  public UserRegistrationDto(UserProfilePictureInformationDto userProfilePictureInformation) {
    this.userProfilePictureInformation = userProfilePictureInformation;
  }

  public UserProfilePictureInformationDto getUserProfilePictureInformation() {
    return userProfilePictureInformation;
  }

  public void setUserProfilePictureInformation(UserProfilePictureInformationDto userProfilePictureInformation) {
    this.userProfilePictureInformation = userProfilePictureInformation;
  }

  public SubscriberInformationDto getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(SubscriberInformationDto subscriber) {
    this.subscriber = subscriber;
  }
}

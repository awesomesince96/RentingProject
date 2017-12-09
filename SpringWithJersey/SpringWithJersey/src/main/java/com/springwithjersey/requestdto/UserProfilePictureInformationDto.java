package com.springwithjersey.requestdto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserProfilePictureInformationDto {
  public String profilePic;
}

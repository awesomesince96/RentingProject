package com.springwithjersey.requestdto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SubscriberInformationDto {
  public static final String ID = "id";
  public static final String COMPANY_ID = "companyId";
  public static final String FIRST_NAME = "firstName";
  public static final String LAST_NAME = "lastName";
  public static final String EMAIL = "email";
  public static final String CONTACT_NUMBER = "contactNumber";
  public static final String ROLE_ID = "role_id";
  public static final String PASSWORD = "password";

  private Long Id;
  @NotNull
  private String companyName;
  private Long companyId;
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
  @NotNull
  @Email
  private String email;
  @NotNull
  private String contactNumber;
  private Long role_id;
  private String authority;
  @NotNull
  private String password;
  private String status;
  private Long roleId;
}

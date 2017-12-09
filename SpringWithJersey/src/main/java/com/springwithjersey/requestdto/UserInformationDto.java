package com.springwithjersey.requestdto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserInformationDto {
  public static final String ID = "id";
  public static final String FIRSTNAME = "firstName";
  public static final String LASTNAME = "lastName";
  public static final String EMAIL = "email";
  public static final String CONTACT_NUMBER = "contactNumber";
  public static final String ROLE_NAME = "roleName";
  public static final String Authority = "authority";
  public static final String STATUS = "status";


  private Long id;
  private Long companyId;
  private String firstName;
  private String lastName;
  private String email;
  private String contactNumber;
  private Long roleId;
  private String roleName;
  private String authority;
  private boolean enable;
  private String status;
  private String companyName;
  private String profilePic;
  private String logo;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the contactNumber
   */
  public String getContactNumber() {
    return contactNumber;
  }

  /**
   * @param contactNumber the contactNumber to set
   */
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }



}

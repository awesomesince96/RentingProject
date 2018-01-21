package com.springwithjersey.requestdto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

@Data
// @EqualsAndHashCode(callSuper = false)
public class UpdateUserInformationDto {
  @NotNull
  private Long id;
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
  @NotNull
  @Email
  private String email;
  @NotNull
  private String contactNumber;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }


}

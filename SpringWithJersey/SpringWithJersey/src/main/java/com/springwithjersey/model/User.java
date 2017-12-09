package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Model {

  private static final long serialVersionUID = -4197834021095332700L;

  public static final String ID = MODEL_ID;
  public static final String FIRSTNAME = "firstName";
  public static final String LASTNAME = "lastName";
  public static final String EMAIL = "email";
  public static final String CONTACT_NUMBER = "contactNumber";
  public static final String STATUS = "status";
  public static final String PASSWORD = "password";


  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "unique_id")
  private String uuid;

  @Column(name = "contact_number")
  private String contactNumber;

  @Column(name = "profile_pic")
  private byte[] profilePic;

  @Column(name = "password")
  private String password;

  @Column(name = "status")
  private String status;

  @Column(name = "isDeleted")
  private boolean isDeleted;

  @JoinColumn(name = "role_id", referencedColumnName = MODEL_ID)
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

}

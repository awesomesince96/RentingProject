package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springwithjersey.common.util.Role;
import com.springwithjersey.common.util.Status;

@Entity
@Table(name = "User")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "contact_number")
  private String contactNumber;

  @Column(name = "email")
  private String email;

  @JsonIgnore
  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private Role role;

  @Column(name = "status")
  private Status status;

  // @OneToMany(mappedBy = "user")
  // private Set<Item> item;

  public User() {
    super();
  }

  public User(long id, String firstName, String lastName, String contactNumber, String email, String password,
      Role role, Status status) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.contactNumber = contactNumber;
    this.email = email;
    this.password = password;
    this.role = role;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber=" + contactNumber
        + ", email=" + email + ", password=" + password + ", role=" + role + ", status=" + status + "]";
  }

  // public Set<Item> getItem() {
  // return item;
  // }
  //
  // public void setItem(Set<Item> item) {
  // this.item = item;
  // }

}

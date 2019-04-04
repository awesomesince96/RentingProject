package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springwithjersey.common.util.Status;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "house_no")
  private String houseNo;

  @Column(name = "street")
  private String street;

  @Column(name = "area")
  private String area;

  @Column(name = "landmark")
  private String landmark;

  @Column(name = "pincode")
  private int pincode;

  @Column(name = "alt_number")
  private String number;

  @ManyToOne
  @JoinColumn(name = "city")
  private City city;

  @ManyToOne
  @JoinColumn(name = "user")
  private User user;

  @Column(name = "status")
  private Status status;

  public Address() {
    super();
  }

  public Address(long id, String houseNo, String street, String area, String landmark, int pincode, String number,
      Status status) {
    super();
    this.id = id;
    this.houseNo = houseNo;
    this.street = street;
    this.area = area;
    this.landmark = landmark;
    this.pincode = pincode;
    this.number = number;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getHouseNo() {
    return houseNo;
  }

  public void setHouseNo(String houseNo) {
    this.houseNo = houseNo;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getLandmark() {
    return landmark;
  }

  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }

  public int getPincode() {
    return pincode;
  }

  public void setPincode(int pincode) {
    this.pincode = pincode;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  // public User getUser() {
  // return user;
  // }
  //
  // public void setUser(User user) {
  // this.user = user;
  // }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Address [id=" + id + ", houseNo=" + houseNo + ", street=" + street + ", area=" + area + ", landmark="
        + landmark + ", pincode=" + pincode + ", number=" + number + ", user=" + user + ", status=" + status + "]";
  }

}

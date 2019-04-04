package com.springwithjersey.model;

import java.util.Date;

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
@Table(name = "Item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "deposit")
  private long deposit;

  @ManyToOne
  @JoinColumn(name = "sub_cat")
  private SubCategory subcategory;

  @Column(name = "registration")
  private Date registration;

  @Column(name = "status")
  private Status status;

  @ManyToOne
  @JoinColumn(name = "user")
  private User user;

  // @OneToMany(mappedBy = "item")
  // private Set<PlanItem> planitem;

  public Item() {
    super();
  }

  public Item(long id, String name, String description, long deposit, SubCategory subcategory, Date registration,
      Status status, User user) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.deposit = deposit;
    this.subcategory = subcategory;
    this.registration = registration;
    this.status = status;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SubCategory getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(SubCategory subcategory) {
    this.subcategory = subcategory;
  }

  public Date getRegistration() {
    return registration;
  }

  public void setRegistration(Date registration) {
    this.registration = registration;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public long getDeposit() {
    return deposit;
  }

  public void setDeposit(long deposit) {
    this.deposit = deposit;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", name=" + name + ", description=" + description + ", deposit=" + deposit
        + ", subcategory=" + subcategory + ", registration=" + registration + ", status=" + status + ", user=" + user
        + "]";
  }
}

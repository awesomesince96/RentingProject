package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springwithjersey.common.util.Status;

@Entity
@Table(name = "Category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private Status status;

  // @OneToMany(mappedBy = "category")
  // private Set<SubCategory> subcategory;

  public Category() {
    super();
  }

  public Category(long id, String name, Status status) {
    super();
    this.id = id;
    this.name = name;
    this.status = status;
  }

  // public Set<SubCategory> getSubcategory() {
  // return subcategory;
  // }
  //
  // public void setSubcategory(Set<SubCategory> subcategory) {
  // this.subcategory = subcategory;
  // }

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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

}

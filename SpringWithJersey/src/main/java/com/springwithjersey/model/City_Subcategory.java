package com.springwithjersey.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city_subcategory")
public class City_Subcategory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @ManyToOne
  @JoinColumn(name = "city")
  private City city;

  @ManyToOne
  @JoinColumn(name = "subcategory")
  private SubCategory subcategory;

  public City_Subcategory() {
    super();
  }

  public City_Subcategory(long id, City city, SubCategory subcategory) {
    super();
    this.id = id;
    this.city = city;
    this.subcategory = subcategory;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public SubCategory getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(SubCategory subcategory) {
    this.subcategory = subcategory;
  }



}

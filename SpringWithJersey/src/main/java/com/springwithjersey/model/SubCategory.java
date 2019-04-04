package com.springwithjersey.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springwithjersey.common.util.Status;

@Entity
@Table(name = "Sub_category")
public class SubCategory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private Status status;

  @ManyToOne
  @JoinColumn(name = "category")
  private Category category;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategory")
  private Set<City_Subcategory> city_subcategory;

  // @ManyToMany(mappedBy = "subCategory", fetch = FetchType.LAZY)
  // @ManyToMany(fetch = FetchType.LAZY)
  // @JoinTable(name = "city_sub_category")
  // private List<City> city;

  // public void addCity(City city) {
  // this.city.add(city);
  // city.getSubCategory().add(this);
  // }
  //
  // public void removeCity(City city) {
  // this.city.remove(city);
  // city.getSubCategory().remove(this);
  // }

  public SubCategory() {
    super();
  }

  public SubCategory(long id, String name, Status status, Category category) {
    super();
    this.id = id;
    this.name = name;
    this.status = status;
    this.category = category;
  }

  public long getId() {
    return id;
  }

  // public SubCategory(long id, String name, Status status, Category category, List<City> city) {
  // super();
  // this.id = id;
  // this.name = name;
  // this.status = status;
  // this.category = category;
  // this.city = city;
  // }

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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  // public Set<City_Subcategory> getCity_subcategory() {
  // return city_subcategory;
  // }
  //
  // public void setCity_subcategory(Set<City_Subcategory> city_subcategory) {
  // this.city_subcategory = city_subcategory;
  // }

  // public List<City> getCity() {
  // return city;
  // }
  //
  // public void setCity(List<City> city) {
  // this.city = city;
  // }



}

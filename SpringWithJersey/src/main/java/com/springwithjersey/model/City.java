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

/**
 * @author Krissh
 *
 */
@Entity
@Table(name = "City")
public class City implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "state")
  private State state;

  @Column(name = "status")
  private Status status;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
  private Set<City_Subcategory> city_subcategory;

  // @ManyToMany(mappedBy = "city", fetch = FetchType.LAZY)
  // private List<SubCategory> subCategory;


  public City() {
    super();
  }
  //
  // public City(long id, String name, State state, Status status, List<SubCategory> subCategory) {
  // super();
  // this.id = id;
  // this.name = name;
  // this.state = state;
  // this.status = status;
  // this.subCategory = subCategory;
  // }

  public long getId() {
    return id;
  }

  public City(long id, String name, State state, Status status) {
    super();
    this.id = id;
    this.name = name;
    this.state = state;
    this.status = status;
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

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;

  }


  //
  //
  // public List<SubCategory> getSubCategory() {
  // return subCategory;
  // }
  //
  // public void setSubCategory(List<SubCategory> subCategory) {
  // this.subCategory = subCategory;
  // }

  // public Set<City_Subcategory> getCity_subcategory() {
  // return city_subcategory;
  // }
  //
  // public void setCity_subcategory(Set<City_Subcategory> city_subcategory) {
  // this.city_subcategory = city_subcategory;
  // }

  @Override
  public String toString() {
    return "City [id=" + id + ", name=" + name + ", state=" + state + ", status=" + status + "]";
  }


}

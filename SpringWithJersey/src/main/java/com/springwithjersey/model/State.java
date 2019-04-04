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
@Table(name = "State")
public class State {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  // @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "country")
  private Country country;

  @Column(name = "status")
  private Status status;

  // @OneToMany(mappedBy = "state")
  // private Set<City> city;


  public State() {
    super();
  }

  public State(long id, String name, Country country, Status status) {
    super();
    this.id = id;
    this.name = name;
    this.country = country;
    this.status = status;
  }



  // public Set<City> getCity() {
  // return city;
  // }
  //
  // public void setCity(Set<City> city) {
  // this.city = city;
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

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "State [id=" + id + ", name=" + name + ", country=" + country + ", status=" + status + "]";
  }

}

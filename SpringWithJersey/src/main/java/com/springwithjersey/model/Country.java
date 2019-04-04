package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springwithjersey.common.util.Status;

import lombok.Data;

@Entity
@Table(name = "Country")
@Data
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private Status status;

  // @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
  // @JsonManagedReference
  // private Set<State> state;

  public Country() {
    super();
  }

  public Country(long id, String name, Status status) {
    super();
    this.id = id;
    this.name = name;
    this.status = status;
  }

  // public Set<State> getState() {
  // return state;
  // }
  //
  // public void setState(Set<State> state) {
  // this.state = state;
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

  @Override
  public String toString() {
    return "Country [id=" + id + ", name=" + name + ", status=" + status + "]";
  }

}

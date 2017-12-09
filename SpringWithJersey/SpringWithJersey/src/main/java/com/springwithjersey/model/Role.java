package com.springwithjersey.model;


import org.hibernate.annotations.BatchSize;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role extends Model {
  private static final long serialVersionUID = -6920808705672539533L;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
  @BatchSize(size = 50)
  private List<User> user;

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

}

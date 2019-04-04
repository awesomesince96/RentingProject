package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springwithjersey.common.util.Status;

@Entity
@Table(name = "plan_master")
public class PlanMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "days")
  private String days;

  @Column(name = "status")
  private Status status;

  // @OneToMany(mappedBy = "plan")
  // private Set<PlanItem> planitem;

  public PlanMaster() {
    super();
  }

  public PlanMaster(long id, String name, String days, Status status) {
    super();
    this.id = id;
    this.name = name;
    this.days = days;
    this.status = status;
  }

  // public Set<PlanItem> getPlanitem() {
  // return planitem;
  // }
  //
  // public void setPlanitem(Set<PlanItem> planitem) {
  // this.planitem = planitem;
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

  public String getDays() {
    return days;
  }

  public void setDays(String days) {
    this.days = days;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "PlanMaster [id=" + id + ", name=" + name + ", days=" + days + ", status=" + status + "]";
  }

}

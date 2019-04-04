package com.springwithjersey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Interested_user")
public class InterestedUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @ManyToOne
  @JoinColumn(name = "user")
  private User user;

  @ManyToOne
  @JoinColumn(name = "item")
  private Item item;

  @ManyToOne
  @JoinColumn(name = "plan_item")
  private Item planItem;

  @Column(name = "time")
  private Timestamp time;

  public InterestedUser() {
    super();
  }

  public InterestedUser(long id, User user, Item item, Item planItem, Timestamp time) {
    super();
    this.id = id;
    this.user = user;
    this.item = item;
    this.planItem = planItem;
    this.time = time;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Item getPlanItem() {
    return planItem;
  }

  public void setPlanItem(Item planItem) {
    this.planItem = planItem;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "IntrestedUser [id=" + id + ", user=" + user + ", item=" + item + ", planItem=" + planItem + ", time=" + time
        + "]";
  }

  // @Column(name = "intrested_user")
  // private User intrested_user;
  //
  // @Column(name = "item")
  // private Item item;
  //
  // @Column(name = "plan_item")
  // private PlanItem planItem;

}

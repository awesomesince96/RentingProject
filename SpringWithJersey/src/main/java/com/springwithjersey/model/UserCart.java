package com.springwithjersey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_cart")
public class UserCart {

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
  private PlanItem plan_item;

  public UserCart() {
    super();
  }

  public UserCart(long id, User user, Item item, PlanItem plan_item) {
    super();
    this.id = id;
    this.user = user;
    this.item = item;
    this.plan_item = plan_item;
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

  public PlanItem getPlan_item() {
    return plan_item;
  }

  public void setPlan_item(PlanItem plan_item) {
    this.plan_item = plan_item;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "UserCart [id=" + id + ", user=" + user + ", plan_item=" + plan_item + "]";
  }

}

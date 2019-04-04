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
@Table(name = "Plan_item")
public class PlanItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @ManyToOne
  @JoinColumn(name = "plan")
  private PlanMaster plan;

  @ManyToOne
  @JoinColumn(name = "item")
  private Item item;

  @Column(name = "price")
  private long price;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "status")
  private Status status;

  public PlanItem() {
    super();
  }

  public PlanItem(long id, PlanMaster plan, long price, int quantity, Status status) {
    super();
    this.id = id;
    this.plan = plan;
    this.price = price;
    this.quantity = quantity;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public PlanMaster getPlan() {
    return plan;
  }

  public void setPlan(PlanMaster plan) {
    this.plan = plan;
  }

  // public Item getItem() {
  // return item;
  // }
  //
  // public void setItem(Item item) {
  // this.item = item;
  // }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "PlanItem [id=" + id + ", plan=" + plan + ", price=" + price + ", quantity=" + quantity + ", status="
        + status + "]";
  }
}

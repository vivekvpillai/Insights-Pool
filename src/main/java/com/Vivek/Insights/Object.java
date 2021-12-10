package com.Vivek.Insights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Object {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String itemName;

  private String department;

  private Integer quantity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getitemName() {
    return itemName;
  }

  public void setitemName(String itemName) {
    this.itemName = itemName;
  }

  public String getdepartment() {
    return department;
  }

  public void setdepartment(String department) {
    this.department = department;
  }

  public Integer getquantity() {
    return quantity;
  }

  public void setquantity(Integer quantity){
    this.quantity = quantity;
  }
}

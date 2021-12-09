package com.Vivek.Insights;

import javax.persistence.*;


@Entity
@Table(name= "Object")
public class Object {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private String sampleName;

  private String category;

  private Integer visits;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getsampleName() {
    return sampleName;
  }

  public void setsampleName(String sampleName) {
    this.sampleName = sampleName;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getVisits() {
    return visits;
  }

  public void setVisits(Integer visits){
    this.visits = visits;
  }

  public Object(String sampleName, String category, Integer visits, User user){
    this.sampleName = sampleName;
    this.category = category;
    this.visits = visits;
  }
}

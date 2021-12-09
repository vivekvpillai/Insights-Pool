package com.Vivek.Insights;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
// @Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  @OneToMany(
    mappedBy = "name",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Object> objects = new ArrayList<>();

  public User(String username) {
    this.username = username;

  }

  public void setObject(List<Object> objects) {
    this.objects = objects;
  }

}

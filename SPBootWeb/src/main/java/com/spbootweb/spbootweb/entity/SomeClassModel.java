package com.spbootweb.spbootweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "SomeClass", catalog = "some_base")

public class SomeClassModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "some_id")
  private Long id;

  @Column(name = "some_name")
  private String some_name;

  @Column(name = "some_price")
  private Float some_price;

  public SomeClassModel() {
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSome_name() {
    return some_name;
  }

  public void setSome_name(String some_name) {
    this.some_name = some_name;
  }

  public Float getSome_price() {
    return some_price;
  }

  public void setSome_price(Float some_price) {
    this.some_price = some_price;
  }
}

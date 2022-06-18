package ru.max.crud;

import javax.persistence.*;

/**
 * Rubanenko Maxim
 * 13.06.2022
 */
@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  public Customer() { }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String toString(){
    return  String.format("Customer [id = %d, name = %s]", id, name);
  }

}

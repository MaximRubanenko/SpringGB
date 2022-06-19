package ru.gb.market.market.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Rubanenko Maxim
 * 19.06.2022
 */
@Entity
@Data
@NoArgsConstructor
@Table (name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String name;

  @Column(name = "price")
  private int price;
}

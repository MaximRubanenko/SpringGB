package ru.gb.market.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.market.model.Product;

/**
 * Rubanenko Maxim
 * 19.06.2022
 */
@Data
@NoArgsConstructor
public class ProductDto {
  private Long id;
  private String name;
  private int price;

  public ProductDto(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.price = product.getPrice();
  }
}

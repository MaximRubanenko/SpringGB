package ru.gb.market.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.market.market.dto.ProductDto;
import ru.gb.market.market.model.Product;
import ru.gb.market.market.services.ProductService;

import java.util.List;

/**
 * Rubanenko Maxim
 * 19.06.2022
 */
@RestController
@RequiredArgsConstructor
public class ProductControllerRest {
  private final ProductService productService;

  @GetMapping("/products/{id}")
  public ProductDto findById(@PathVariable Long id){ return new ProductDto(productService.findById(id).get());  }

  @GetMapping("/products")
  public List<Product> findAll() {return productService.findAll();}

  @GetMapping("/products_del/{id}")
  public void deleteById(@PathVariable Long id){ productService.deleteById(id);  }

}

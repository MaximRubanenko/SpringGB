package ru.gb.market.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.market.market.model.Product;
import ru.gb.market.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Rubanenko Maxim
 * 19.06.2022
 */
@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public Optional<Product> findById(Long id){
    return productRepository.findById(id);
  }

  public List<Product> findAll(){
    return productRepository.findAll();
  }

  public void deleteById(Long id){
    productRepository.deleteById(id);
  }
}

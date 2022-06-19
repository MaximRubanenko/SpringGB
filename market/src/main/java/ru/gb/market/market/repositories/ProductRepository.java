package ru.gb.market.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market.market.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Rubanenko Maxim
 * 19.06.2022
 */
public interface ProductRepository  extends JpaRepository<Product, Long> {
  Optional<Product> findById(Long id);
  List<Product> findAll();
  void deleteById(Long Id);

}

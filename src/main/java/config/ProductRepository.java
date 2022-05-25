package config;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Rubanenko Maxim
 * 24.05.2022
 */
@Component
public class ProductRepository {
  private ArrayList<Product> products;

  public ProductRepository() {
    products = new ArrayList<>();
  }

  public void addProduct(Product item){
    products.add(item);
  }
  public ArrayList<Product> getProducts() {
    return products;
  }

  Product getProduct(int id) {
    return products.get(id);
  }

}


package config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Rubanenko Maxim
 * 24.05.2022
 */
@Component
@Scope("prototype")
public class Cart {
  private HashMap<Product, Integer> productsInCart;
  ProductRepository productRepository;

  public Cart(ProductRepository productRepository) {
    productsInCart = new HashMap<>();
    this.productRepository = productRepository;
  }

  public void addProduct(int id) {
    Product product = productRepository.getProduct(id); // Получили продукт из каталога. На корректность id не проверяем
    if (!productsInCart.containsKey(product)) {
      productsInCart.put(product, 1);
    } else {
      productsInCart.put(product, productsInCart.get(product) + 1);
    }
  }

  public boolean delProduct(int id) {
    Product product = productRepository.getProduct(id);
    if (productsInCart.containsKey(product)) {
      productsInCart.put(product, productsInCart.get(product) - 1);
    } else {
      return false;
    }
    if (productsInCart.get(product) <= 0) {
      productsInCart.remove(product);
    }
    return true;
  }

  public boolean delProduct(int id, int count) {
    Product product = productRepository.getProduct(id);
    if (count >= productsInCart.get(product)) {
      productsInCart.remove(product);
      return true;
    }
    for (int i = 0; i < count; i++) {
      if (!delProduct(id)) {
        return false;
      }
    }
    return true;
  }

  public void addProduct(int id, int count) {
    for (int i = 0; i < count; i++) {
      addProduct(id);
    }
  }

  public void displayCart(){
    for(Map.Entry<Product,Integer> product : productsInCart.entrySet()){
      System.out.println(product.getKey().getId() +" "+ product.getKey().getName() +" "+ product.getKey().getPrice() +" " + product.getValue() + " шт.");
    }
  }
}


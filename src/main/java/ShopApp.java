import config.ApplicationConfiguration;
import config.Cart;
import config.Product;
import config.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
/**
 * Rubanenko Maxim
 * 24.05.2022
 */
public class ShopApp {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    Cart cart = context.getBean(Cart.class);
    ProductRepository productRepository = context.getBean(ProductRepository.class);

    Product table = new Product(0,"Table",120);
    Product lamp = new Product(1,"Lamp",70);
    Product carpet = new Product(2,"Carpet",250);
    Product chair = new Product(3,"Chair",90);
    Product tv = new Product(4,"Tv set",340);

    productRepository.addProduct(table);
    productRepository.addProduct(lamp);
    productRepository.addProduct(carpet);
    productRepository.addProduct(chair);
    productRepository.addProduct(tv);

    Scanner scanner = new Scanner(System.in);
    ConsoleInputHandler  input = new ConsoleInputHandler();
    boolean isRun = true;
    while (isRun){
      if (input.validate(scanner.nextLine())) {
        switch (input.getCommand()) {
          case ADD:
            cart.addProduct(input.getId(),input.getCount());
            System.out.println("Добавление товара в корзину");
            break;
          case DEL:
            cart.delProduct(input.getId(),input.getCount());
            System.out.println("Удаление товара из корзины");
            break;
          case RESET:
            cart = context.getBean(Cart.class);
            System.out.println("Новая корзина");
            break;
          case PRINT:
            System.out.println("Товары в корзине");
            cart.displayCart();
            break;
          case QUIT:
            System.out.println("Выход");
            isRun = false;
            break;
        }
      }
    }

  }
}

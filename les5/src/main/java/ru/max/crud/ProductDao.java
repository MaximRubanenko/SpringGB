package ru.max.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Rubanenko Maxim
 * 07.06.2022
 * 2. Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций
 * над сущностью Product (Product
 * findById(Long id),
 * List<Product> findAll(),
 * void deleteById(Long id),
 * Product saveOrUpdate(Product product));
 */

public class ProductDao {
  private static SessionFactory factory;

  public static void main(String[] args) {
    try {
      System.out.println("Start");
      factory = new Configuration()
          .configure("config/crud/hibernate.cfg.xml")
          .buildSessionFactory();

      deleteById(4L);
      System.out.println(findById(2L).toString());
      for (Product p : findAll()) {
        System.out.println(p.toString());
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      shutdown();
    }
  }


  private static void shutdown() {
    factory.close();
  }

  public static void deleteById(Long id) {
    try (Session session = factory.getCurrentSession()) {
      session.beginTransaction();
      Product product = session.get(Product.class, id);
      session.delete(product);
      session.getTransaction().commit();
    }
  }


  public static List<Product> findAll() {
    try (Session session = factory.getCurrentSession()) {
      session.beginTransaction();
      List<Product> productsAll = session.createQuery("from Product").getResultList();
      session.getTransaction().commit();
      return productsAll;
    }
  }

  public static Product findById(Long id) {
    try (Session session = factory.getCurrentSession()) {
      session.beginTransaction();
      Product product = session.get(Product.class, id);
      session.getTransaction().commit();

      return product;
    }
  }

  public static void saveOrUpdate(Product p) {

    try (Session session = factory.getCurrentSession()) {
      session.beginTransaction();
      //
      session.getTransaction().commit();
    }
  }
}

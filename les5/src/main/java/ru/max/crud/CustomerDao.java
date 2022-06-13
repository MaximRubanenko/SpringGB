package ru.max.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Rubanenko Maxim
 * 13.06.2022
 */
public class CustomerDao {

  public static List<Customer> findAll(SessionFactory factory) {
    try (Session session = factory.getCurrentSession()) {
      session.beginTransaction();
      List<Customer> customerAll = session.createQuery("from Customer").getResultList();
      session.getTransaction().commit();
      return customerAll;
    }
  }
}

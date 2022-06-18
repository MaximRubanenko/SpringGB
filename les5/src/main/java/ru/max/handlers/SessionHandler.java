package ru.max.handlers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Rubanenko Maxim
 * 13.06.2022
 */
public  class SessionHandler {
  private static SessionFactory factory;

  public SessionHandler() {
    this.factory = new Configuration()
        .configure("config/crud/hibernate.cfg.xml")
        .buildSessionFactory();
  }

  public static SessionFactory getFactory() {
    return factory;
  }

  public static void closeFactory() {
          factory.close();
  }
}



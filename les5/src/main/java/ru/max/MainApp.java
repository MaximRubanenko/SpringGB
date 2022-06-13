package ru.max;

import org.hibernate.SessionFactory;
import ru.max.crud.CustomerDao;
import ru.max.crud.ProductDao;
import ru.max.handlers.SessionHandler;

/**
 * Rubanenko Maxim
 * 13.06.2022
 */
public class MainApp {
  public static void main(String[] args) {
    SessionHandler sessionHandler = new SessionHandler();
    SessionFactory factory = SessionHandler.getFactory();


    PrepareDataApp.forcePrepareData(factory);
    for (var p : ProductDao.findAll(factory)) { System.out.println(p.toString()); }

    for (var c : CustomerDao.findAll(factory)) { System.out.println(c.toString()); }

    SessionHandler.closeFactory();
  }
}

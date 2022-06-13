package ru.max;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import ru.max.crud.ProductDao;
import ru.max.handlers.SessionHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
/**
 * Rubanenko Maxim
 * 07.06.2022
 */
public class PrepareDataApp {
  public static void forcePrepareData(SessionFactory factory) {

    Session session = factory.getCurrentSession();
    try {
      String sql = Files.lines(Paths.get("src/full.sql")).collect(Collectors.joining(" "));
      session.beginTransaction();
      session.createNativeQuery(sql).executeUpdate();
      session.getTransaction().commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
//      factory.close();
//      if (session != null) {
//        session.close();
      }
    }
  }



package ru.max;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
/**
 * Rubanenko Maxim
 * 07.06.2022
 */
public class PrepareDataApp {
  public static void forcePrepareData() {
    SessionFactory factory = new Configuration()
        .configure("config/crud/hibernate.cfg.xml")
        .buildSessionFactory();
    Session session = null;
    try {
      String sql = Files.lines(Paths.get("C:\\DEV\\REPO\\les2\\les5\\src\\full.sql")).collect(Collectors.joining(" "));
      session = factory.getCurrentSession();
      session.beginTransaction();
//      session.createNativeQuery(sql).executeUpdate();
      session.getTransaction().commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      factory.close();
      if (session != null) {
        session.close();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    forcePrepareData();
  }
}

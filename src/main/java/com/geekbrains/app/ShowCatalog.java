package com.geekbrains.app;

import shop.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Rubanenko Maxim
 * 18.05.2022
 */
public class ShowCatalog extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Product item1 = new Product(1,"TV Set", 120000);
    Product item2 = new Product(2,"Stouve", 110000);
    Product item3 = new Product(3,"Table", 130000);
    Product item4 = new Product(4,"Kitten", 11000);
    Product item5 = new Product(5,"Pool", 80000);
    Product item6 = new Product(6,"Chair", 35000);
    Product item7 = new Product(7,"Door", 1700);
    Product item8 = new Product(8,"Wash machine", 83000);
    Product item9 = new Product(9,"Glass", 110);
    Product item10 = new Product(10,"Carpet", 710000);


    resp.getWriter().printf("<html><body>");
    resp.getWriter().printf("<p>Catalog</p>");
    resp.getWriter().printf(item1.getItems()+"<br>");
    resp.getWriter().printf(item2.getItems()+"<br>");
    resp.getWriter().printf(item3.getItems()+"<br>");
    resp.getWriter().printf(item4.getItems()+"<br>");
    resp.getWriter().printf(item5.getItems()+"<br>");
    resp.getWriter().printf(item6.getItems()+"<br>");
    resp.getWriter().printf(item7.getItems()+"<br>");
    resp.getWriter().printf(item8.getItems()+"<br>");
    resp.getWriter().printf(item9.getItems()+"<br>");
    resp.getWriter().printf(item10.getItems()+"<br>");
    resp.getWriter().printf("</body></html>");
  }


  @Override
  public void init() throws ServletException {
  }
}

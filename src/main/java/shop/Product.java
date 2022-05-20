package shop;
/**
 * Rubanenko Maxim
 * 18.05.2022
 */

public class Product {
  private int id;
  private String title;
  private int cost;

  public Product(int id, String title, int cost) {
    this.id = id;
    this.title = title;
    this.cost = cost;
  }

//  public Product() {
//    this.id = 1;  this.title = "TV Set";    this.cost = 120000;
//
//  }

  public String getItems(){
    return id + " "+ title + " " + cost;
  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }





}

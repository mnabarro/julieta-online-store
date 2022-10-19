package gradle.java.infraestructure.presentation;

import gradle.java.domain.Product;
import gradle.java.infraestructure.dataaccess.Database;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsChoice {

  private final Database database = new Database();

  public void showProductsToChoose() {
      String menuOption;
      ArrayList<Product> catalogue = database.findAll();

    System.out.println("Which product would you like to explore?");
    for (Product product: catalogue) {
        menuOption = product.showId() + " - " + product.showImage();
        System.out.println(menuOption);
    }

    Scanner myObj = new Scanner(System.in);
    String selection = myObj.nextLine();

    if (selection.equals(catalogue.get(0).showId())) {
      System.out.println("DESCRIPTION :" +catalogue.get(0).showFeaturedAttribute());
    } else if (selection.equals(catalogue.get(1).showId())) {
        System.out.println("DESCRIPTION :" + catalogue.get(1).showFeaturedAttribute());
    } else {
        System.out.println("Sorry, the product doesn't exist");
    }
  }
}

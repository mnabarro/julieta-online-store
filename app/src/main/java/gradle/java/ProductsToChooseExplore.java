package gradle.java;

import gradle.java.domain.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsToChooseExplore {

  private final ProductWarehouse productWarehouse = new ProductWarehouse();

  public void productsToChooseExplore() {
      String menuOption;
      ArrayList<Product> catalogue = productWarehouse.findAll();

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

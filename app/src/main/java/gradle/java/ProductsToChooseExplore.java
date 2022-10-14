package gradle.java;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductsToChooseExplore {

  private final ProductWarehouse productWarehouse = new ProductWarehouse();

  public void productsToChooseExplore() {
    ArrayList<Product> products = productWarehouse.findAll();

    System.out.println("Which product would you like to explore?");
    String option1 = products.get(0).showId() + " - " + products.get(0).showImage();
    String option2 = products.get(1).showId() + " - " + products.get(1).showImage();
    System.out.println(option1);
    System.out.println(option2);

    Scanner myObj = new Scanner(System.in);
    String selection = myObj.nextLine();

    if (selection.equals(products.get(0).showId())) {
      System.out.println("DESCRIPTION :" +products.get(0).showFeaturedAttribute());
    } else if (selection.equals(products.get(1).showId())) {
        System.out.println("DESCRIPTION :" + products.get(1).showFeaturedAttribute());
    } else {
        System.out.println("Sorry, the product doesn't exist");
    }
  }
}

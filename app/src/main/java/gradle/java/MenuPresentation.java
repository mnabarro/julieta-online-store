package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPresentation {

  private final ProductRepository database;

  public MenuPresentation(ProductRepository database) {
    this.database = database;
  }
  public void decideWhatToDoNext(){
    System.out.println("\n");
    System.out.println("¿What would you like to do next?");
    String nextOption1 = "1 - Add product to cart";
    String nextOption2 = "2 - Keep browsing products";
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner myObj = new Scanner(System.in);
    String chosenOption = myObj.nextLine();

    if(chosenOption.equals("1")){
      System.out.println();
    } else if (chosenOption.equals("2")) {
      ArrayList<Product> catalogue = database.findAll();
      String formattedCatalogue = this.formattedCatalogue(catalogue);
      System.out.println(formattedCatalogue);
    } else System.out.println("Sorry, you have to choose one valid option");
  }

}

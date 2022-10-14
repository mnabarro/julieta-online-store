package gradle.java;

import gradle.java.domain.Product;
import java.util.ArrayList;
import java.util.Scanner;


public class CatalogueFormatter {
    ProductsToChooseExplore productsToChooseExplore = new ProductsToChooseExplore();
    DecideStepToContinue decideStepToContinue = new DecideStepToContinue();
    ProductWarehouse productWarehouse = new ProductWarehouse();
    public String format(ArrayList<Product> catalogue){
        for (Product product : catalogue){
            System.out.println(product.showImage());
            System.out.println(product.showDescription());
            System.out.println(product.showFeaturedAttribute());
            System.out.println(product.showPrice());
            System.out.println(product.showReference());
            System.out.println("\n");
        }
        productsToChooseExplore.productsToChooseExplore();
        decideWhatToDoNext();
        return "";
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
            ArrayList<Product> catalogue = productWarehouse.findAll();
            String formattedCatalogue = this.format(catalogue);
            System.out.println(formattedCatalogue);
        } else System.out.println("Sorry, you have to choose one valid option");
    }

}

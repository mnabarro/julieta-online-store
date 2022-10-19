package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.presentation.CatalogDataFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineShop {
    private final ProductRepository database;
    private final CatalogDataFormatter catalogFormatter;
    public OnlineShop(ProductRepository database, CatalogDataFormatter catalogFormatter) {
        this.database = database;
        this.catalogFormatter = catalogFormatter;
    }

    public void showProducts() {

        ArrayList<Product> catalog = database.findAll();
        String formattedCatalog = catalogFormatter.formattedCatalog(catalog);
        System.out.println(formattedCatalog);

        decideWhatToDoNext();
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

            showProducts();

        } else System.out.println("Sorry, you have to choose one valid option");
    }

    public void showProductsToChoose() {
        String menuOption;
        ArrayList<Product> catalogue = database.findAll();

        System.out.println("Which product would you like to explore?");
        for (Product product: catalogue) {
            menuOption = product.id + " - " + product.image;
            System.out.println(menuOption);
        }

        Scanner myObj = new Scanner(System.in);
        String selection = myObj.nextLine();

        if (selection.equals(catalogue.get(0).id)) {
            System.out.println("DESCRIPTION :" +catalogue.get(0).featuredAttribute);
        } else if (selection.equals(catalogue.get(1).id)) {
            System.out.println("DESCRIPTION :" + catalogue.get(1).featuredAttribute);
        } else {
            System.out.println("Sorry, the product doesn't exist");
        }
    }
}

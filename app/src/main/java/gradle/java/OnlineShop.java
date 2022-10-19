package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineShop {
    private final ProductRepository database;
    private final CatalogFormatter catalogFormatter;
    public OnlineShop(ProductRepository database, CatalogFormatter catalogFormatter) {
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

            ArrayList<Product> catalog = database.findAll();
            String formattedCatalog = catalogFormatter.formattedCatalog(catalog);
            System.out.println(formattedCatalog);

        } else System.out.println("Sorry, you have to choose one valid option");
    }

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

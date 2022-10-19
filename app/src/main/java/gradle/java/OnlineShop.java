package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuStrings;
import java.util.ArrayList;
import java.util.Objects;
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
    }

    public void decideWhatToDoNext(){
        StringBuilder textMenu = new StringBuilder();

        textMenu.append("\n");
        textMenu.append(MenuStrings.WHATTODONEXT).append("\n");
        textMenu.append(MenuStrings.OPTION1);
        textMenu.append(MenuStrings.ADDPRODUCTTOCART).append("\n");
        textMenu.append(MenuStrings.OPTION2);
        textMenu.append(MenuStrings.KEEPBROWSING).append("\n");
        textMenu.append("\n");
        System.out.println(textMenu);

        Scanner myObj = new Scanner(System.in);
        String chosenOption = myObj.nextLine();

        if(chosenOption.equals("1")){
            System.out.println();
        } else if (chosenOption.equals("2")) {

            showProducts();

        } else System.out.println(MenuStrings.CHOOSEVALIDOPTION);
    }

    public void selectProductToExplore() {

        ArrayList<Product> catalogue = database.findAll();

        System.out.println(MenuStrings.WICHPRODUCT);

        Scanner myObj = new Scanner(System.in);
        String selection = "";
        Boolean productFound = false;

        while(!productFound) {
            selection = myObj.nextLine();
            if( selection.equals("ABC")) {
                productFound = true;
            }
            System.out.println(MenuStrings.PRODUCTDOESNTEXISTS);
        }
        System.out.println("CHAU!");

//        if (selection.equals(catalogue.get(0).reference)) {
//            System.out.println("DESCRIPTION :" +catalogue.get(0).higlightedAttribute);
//        } else if (selection.equals(catalogue.get(1).reference)) {
//            System.out.println("DESCRIPTION :" + catalogue.get(1).higlightedAttribute);
//        } else {
//            System.out.println(MenuStrings.PRODUCTDOESNTEXISTS);
//        }
    }
}

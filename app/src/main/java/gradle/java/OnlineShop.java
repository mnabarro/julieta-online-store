package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuStrings;
import gradle.java.infraestructure.presentation.ProductFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class OnlineShop {
    private final ProductRepository database;
    private final CatalogFormatter catalogFormatter;
    private final ProductFormatter productFormatter;

    public OnlineShop(ProductRepository database, CatalogFormatter catalogFormatter, ProductFormatter productFormatter) {
        this.database = database;
        this.catalogFormatter = catalogFormatter;
        this.productFormatter = productFormatter;
    }

    public void showCliShop () {
        Optional<Product> productILookFor = Optional.empty();

        showProducts();

        while(productILookFor.isEmpty()) {

            productILookFor = selectProductToViewDetails();

            if (productILookFor.isPresent()) {
                System.out.println(productFormatter.formattedProductDetail(productILookFor.get()));
            } else {
                System.out.println(MenuStrings.productDoesntExists);
                System.out.println("\n");
            }
        }
    }

    public void showProducts() {

        ArrayList<Product> catalog = database.findAll();
        String formattedCatalog = catalogFormatter.formattedCatalog(catalog);
        System.out.println(formattedCatalog);
    }

    public void decideWhatToDoNext(){
        StringBuilder textMenu = new StringBuilder();

        textMenu.append("\n");
        textMenu.append(MenuStrings.whatToDoNext).append("\n");
        textMenu.append(MenuStrings.option1);
        textMenu.append(MenuStrings.addProductToCart).append("\n");
        textMenu.append(MenuStrings.option2);
        textMenu.append(MenuStrings.keepBrowsing).append("\n");
        textMenu.append("\n");
        System.out.println(textMenu);

        Scanner myObj = new Scanner(System.in);
        String chosenOption = myObj.nextLine();

        if(chosenOption.equals(MenuStrings.option1.substring(1,2))){
            System.out.println("addto");
        } else if (chosenOption.equals(MenuStrings.option2.substring(1,2))) {
            System.out.println("keep");;
        }
        else
            System.out.println(MenuStrings.chooseValidOption);
    }

    public Optional<Product> selectProductToViewDetails() {

        System.out.println(MenuStrings.wichProduct);

        Scanner userInput = new Scanner(System.in);
        String referenceToLookFor = userInput.nextLine();

        return database.findByReference(referenceToLookFor);

    }
}

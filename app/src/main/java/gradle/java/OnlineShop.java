package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuOptions;
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

    public void cliOnlineShop() {
        Optional<Product> productILookFor = Optional.empty();

        while(productILookFor.isEmpty()) {

            showProducts();

            productILookFor = selectProductToViewDetails();

            if (productILookFor.isPresent()) {
                cliOutput(productFormatter.formattedProductDetail(productILookFor.get()));

                if ( decideWhatToDoNext() == MenuOptions.addToCart) {
                    cliOutput("Add to cart action");
                } else if ( decideWhatToDoNext() == MenuOptions.keepBrowsing) {
                    cliOutput("Keep browsing");
                } else {
                    cliOutput(MenuStrings.chooseValidOption);
                }

            } else {
                cliOutput(MenuStrings.productDoesntExists);
                cliOutput("\n");
            }
        }
    }

    private void cliOutput(String text) {
        System.out.println(text);
    }
    public void showProducts() {

        ArrayList<Product> catalog = database.findAll();
        String formattedCatalog = catalogFormatter.formattedCatalog(catalog);
        cliOutput(formattedCatalog);
    }

    public Optional<Product> selectProductToViewDetails() {

        cliOutput(MenuStrings.wichProduct);

        Scanner userInput = new Scanner(System.in);
        String referenceToLookFor = userInput.nextLine();

        return database.findByReference(referenceToLookFor);
    }

    public String decideWhatToDoNext(){
        StringBuilder textMenu = new StringBuilder();

        textMenu.append("\n");
        textMenu.append(MenuStrings.whatToDoNext).append("\n");
        textMenu.append(MenuStrings.optionNumberOneWithDash).append(MenuStrings.addProductToCart).append("\n");
        textMenu.append(MenuStrings.optionNumberTwoWithDash).append(MenuStrings.keepBrowsing).append("\n");
        textMenu.append("\n");
        cliOutput(textMenu.toString());

        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();

    }
}

package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infraestructure.dataaccess.ProductWarehouse;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuOptions;
import gradle.java.infraestructure.presentation.MenuStrings;
import gradle.java.infraestructure.presentation.ProductFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class OnlineShop {
  private final ProductRepository database;
  private final CatalogFormatter catalogFormatter;
  private final ProductFormatter productFormatter;

  private final ProductWarehouse productWarehouse;
  public OnlineShop(ProductRepository database, CatalogFormatter catalogFormatter, ProductFormatter productFormatter,
    ProductWarehouse productWarehouse) {
    this.database = database;
    this.catalogFormatter = catalogFormatter;
    this.productFormatter = productFormatter;
    this.productWarehouse = productWarehouse;
  }

  public void cliOnlineShop() {
    Optional<Product> productILookFor;

    while (true) {

      showProducts();

      productILookFor = selectProductToViewDetails();

      if (productILookFor.isPresent()) {
        consoleOut(productFormatter.formattedProductDetail(productILookFor.get(), productWarehouse.getStockByReference(productILookFor.get().reference)));

        String userChoice = addToCartOrKeepBrowsing();

        if (Objects.equals(userChoice, MenuOptions.addToCart)) {
          System.exit(0);

        } else if (Objects.equals(userChoice, MenuOptions.keepBrowsing)) {
          consoleOut("Keep browsing");
        } else {
          consoleOut(MenuStrings.chooseValidOption);
          waitForUserToPressEnter();
        }

      } else {
        consoleOut(MenuStrings.productDoesntExists);
        waitForUserToPressEnter();
      }
    }
  }

  private void waitForUserToPressEnter() {
    consoleOut(MenuStrings.pressEnterToContinue);
    Scanner userInput = new Scanner(System.in);
    userInput.nextLine();
  }

  private void consoleOut(String text) {
    System.out.println(text);
  }

  public void showProducts() {

    ArrayList<Product> catalog = database.findAll();
    String formattedCatalog = catalogFormatter.formattedCatalog(catalog);
    consoleOut(formattedCatalog);
  }

  public Optional<Product> selectProductToViewDetails() {

    consoleOut(MenuStrings.wichProduct);

    Scanner userInput = new Scanner(System.in);
    String referenceToLookFor = userInput.nextLine();

    return database.findByReference(referenceToLookFor);
  }

  public String addToCartOrKeepBrowsing() {
    StringBuilder textMenu = new StringBuilder();

    textMenu.append("\n");
    textMenu.append(MenuStrings.whatToDoNext).append("\n");
    textMenu.append(MenuStrings.optionNumberOneWithDash).append(MenuStrings.addProductToCart).append("\n");
    textMenu.append(MenuStrings.optionNumberTwoWithDash).append(MenuStrings.keepBrowsing).append("\n");
    textMenu.append("\n");
    consoleOut(textMenu.toString());

    Scanner userInput = new Scanner(System.in);
    String userSelection = userInput.nextLine();
    return userSelection;

  }
}

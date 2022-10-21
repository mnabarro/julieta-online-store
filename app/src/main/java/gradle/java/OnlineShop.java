package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.domain.StockRepository;
import gradle.java.domain.UserInterface;
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
  private final StockRepository productWarehouse;
  private final UserInterface userInterface;

  public OnlineShop(ProductRepository database, CatalogFormatter catalogFormatter, ProductFormatter productFormatter,
    StockRepository productWarehouse, UserInterface userInterface) {
    this.database = database;
    this.catalogFormatter = catalogFormatter;
    this.productFormatter = productFormatter;
    this.productWarehouse = productWarehouse;
    this.userInterface = userInterface;
  }

  public void cliOnlineShop() {
    Optional<Product> productILookFor;

    while (true) {

      showProducts();

      productILookFor = selectProductToViewDetails();

      if (productILookFor.isPresent()) {
        Integer itemStock = productWarehouse.getStockByReference(productILookFor.get().reference);

        userInterface.sendMessage(productFormatter.formattedProductDetail(productILookFor.get(), itemStock));

        String userChoice = addToCartOrKeepBrowsing();

        if (Objects.equals(userChoice, MenuOptions.addToCart)) {
          System.exit(0);

        } else if (Objects.equals(userChoice, MenuOptions.keepBrowsing)) {
          userInterface.sendMessage("Keep browsing");
        } else {
          userInterface.sendMessage(MenuStrings.chooseValidOption);
          userInterface.waitForUserInput(MenuStrings.pressEnterToContinue);
        }

      } else {
        userInterface.sendMessage(MenuStrings.productDoesntExists);
        userInterface.waitForUserInput(MenuStrings.pressEnterToContinue);
      }
    }
  }

  public void showProducts() {

    ArrayList<Product> catalog = database.findAll();
    String formattedCatalog = catalogFormatter.formattedCatalog(catalog);
    userInterface.sendMessage(formattedCatalog);
  }

  public Optional<Product> selectProductToViewDetails() {

    userInterface.sendMessage(MenuStrings.wichProduct);

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
    userInterface.sendMessage(textMenu.toString());

    Scanner userInput = new Scanner(System.in);
    String userSelection = userInput.nextLine();
    return userSelection;

  }
}

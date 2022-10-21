package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.domain.StockRepository;
import gradle.java.domain.UserInterface;
import gradle.java.infraestructure.presentation.CatalogFormatter;
import gradle.java.infraestructure.presentation.MenuOptions;
import gradle.java.infraestructure.presentation.MenuMessages;
import gradle.java.infraestructure.presentation.ProductFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class OnlineShop {

  private final ProductRepository database;
  private final CatalogFormatter catalogFormatter;
  private final ProductFormatter productFormatter;
  private final StockRepository productWarehouse;
  private final UserInterface ui;

  public OnlineShop(ProductRepository database, CatalogFormatter catalogFormatter, ProductFormatter productFormatter,
    StockRepository productWarehouse, UserInterface userInterface) {
    this.database = database;
    this.catalogFormatter = catalogFormatter;
    this.productFormatter = productFormatter;
    this.productWarehouse = productWarehouse;
    this.ui = userInterface;
  }

  public void run() {
    Optional<Product> productILookFor;

    while (true) {

      showProducts();

      productILookFor = selectProductToViewDetails();

      if (productILookFor.isPresent()) {
        Integer itemStock = productWarehouse.getStockByReference(productILookFor.get().reference);

        ui.sendMessage(productFormatter.formattedProductDetail(productILookFor.get(), itemStock));

        String userChoice = ui.waitForUserInput(ui.addToCartOrKeepBrowsingMessage());

        if (Objects.equals(userChoice, MenuOptions.addToCart)) {
          System.exit(0);

        } else if (Objects.equals(userChoice, MenuOptions.keepBrowsing)) {
          ui.sendMessage("Keep browsing");
        } else {
          ui.sendMessage(MenuMessages.chooseValidOption);
          ui.waitForUserInput(MenuMessages.pressEnterToContinue);
        }

      } else {
        ui.sendMessage(MenuMessages.productDoesntExists);
        ui.waitForUserInput(MenuMessages.pressEnterToContinue);
      }
    }
  }

  public void showProducts() {

    ArrayList<Product> catalog = database.findAll();
    String formattedCatalog = catalogFormatter.formattedCatalog(catalog);

    ui.sendMessage(formattedCatalog);
  }

  public Optional<Product> selectProductToViewDetails() {

    String referenceToLookFor = ui.waitForUserInput(MenuMessages.wichProduct);

    return database.findByReference(referenceToLookFor);
  }
}

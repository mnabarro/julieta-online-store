package gradle.java.infraestructure.presentation;

public class MenuMessages {

  public final static String whatToDoNext = "¿What would you like to do next?";
  public final static String whichProductToExplore = "Which product would you like to explore?\n- Introduce a product's reference.";
  public final static String addProductToCart = "Add product to cart";
  public final static String keepBrowsing = "Keep browsing products";
  public final static String optionNumberOneWithDash = "1 - ";
  public final static String optionNumberTwoWithDash = "2 - ";
  public final static String chooseValidOption = "Sorry, you have to choose one valid option";
  public final static String productDoesntExists = "Sorry, the product doesn't exist";
  public static final String pressEnterToContinue = "Press <ENTER> to continue";
  public static String addToCartOrKeepBrowsingMessage() {

    StringBuilder menuPrompt = new StringBuilder();

    menuPrompt.append(newLine());
    menuPrompt.append(MenuMessages.whatToDoNext).append(newLine()).append(newLine());
    menuPrompt.append(MenuMessages.optionNumberOneWithDash).append(MenuMessages.addProductToCart).append(newLine());
    menuPrompt.append(MenuMessages.optionNumberTwoWithDash).append(MenuMessages.keepBrowsing).append(newLine());
    menuPrompt.append(newLine());
    return menuPrompt.toString();
  }

  public static String newLine() {
    return System.lineSeparator();
  }
}

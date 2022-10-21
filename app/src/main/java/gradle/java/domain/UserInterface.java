package gradle.java.domain;

public interface UserInterface {

  public void sendMessage(String message);
  public String waitForUserInput(String message);
  public String newLine();
  public String addToCartOrKeepBrowsingMessage();
}

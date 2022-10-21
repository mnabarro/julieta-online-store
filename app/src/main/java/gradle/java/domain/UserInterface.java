package gradle.java.domain;

public interface UserInterface {

  void sendMessage(String message);
  String waitForUserInput(String message);
  String newLine();
  String addToCartOrKeepBrowsingMessage();
}

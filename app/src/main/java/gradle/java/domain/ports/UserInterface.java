package gradle.java.domain.ports;

public interface UserInterface {

  void sendMessage(String message);

  String getUserInput();
}

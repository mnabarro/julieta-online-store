package gradle.java.infraestructure.presentation.http;

import gradle.java.domain.ports.UserInterface;

public class HttpUserInterface implements UserInterface {

  @Override
  public void sendMessage(String message) {

  }

  @Override
  public String getUserInput() {
    return null;
  }
}

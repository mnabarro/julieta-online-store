package gradle.java.domain;

import java.util.Optional;

public interface UserInterface {

  void sendMessage(String message);

  String waitForUserInput(String message, Optional<Object> hardwareLayer);
}

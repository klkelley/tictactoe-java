package me.karakelley.tictactoe.UI;

import me.karakelley.tictactoe.UI.validators.PlayerTypeValidator;
import me.karakelley.tictactoe.UI.validators.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTypeValidatorTest {

  @Test
  public void testInputIsValid() {
    Validator playerTypeValidator = new PlayerTypeValidator();

    assertEquals(true, playerTypeValidator.isValidInput("3"));
  }

  @Test
  public void testInputIsInvalid() {
    Validator playerTypeValidator = new PlayerTypeValidator();

    assertEquals(false, playerTypeValidator.isValidInput("f"));
  }
}
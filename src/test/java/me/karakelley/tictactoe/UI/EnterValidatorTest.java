package me.karakelley.tictactoe.UI;

import me.karakelley.tictactoe.UI.validators.EnterValidator;
import me.karakelley.tictactoe.UI.validators.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterValidatorTest {

  @Test
  public void testInValidInput() {
    Validator enterValidator = new EnterValidator();

    assertEquals(true, enterValidator.isValidInput(""));
  }

}
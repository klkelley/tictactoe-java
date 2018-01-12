package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterValidatorTest {

  @Test
  public void testInValidInput() {
    Validator enterValidator = new EnterValidator();

    assertEquals(true, enterValidator.isValidInput("\r"));
  }

}
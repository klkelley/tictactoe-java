package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

  @Test
  public void testInputIsInvalid() {
    Validator validator = new NumberValidator();

    assertEquals(false, validator.isValidInput("-3"));
  }

  @Test
  public void testInputIsValid() {
    Validator validator = new NumberValidator();

    assertEquals(true, validator.isValidInput("3"));
  }

}
package me.karakelley.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTypeValidatorTest {

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
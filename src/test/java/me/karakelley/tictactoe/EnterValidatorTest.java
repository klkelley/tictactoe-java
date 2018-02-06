package me.karakelley.tictactoe;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnterValidatorTest {

  @Test
  public void testInValidInput() {
    Validator enterValidator = new EnterValidator();

    assertEquals(true, enterValidator.isValidInput(""));
  }

}
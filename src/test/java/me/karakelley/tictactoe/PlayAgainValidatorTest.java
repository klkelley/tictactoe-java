package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayAgainValidatorTest {

  @Test
  public void testValidInputForYes() {
    Validator validator = new PlayAgainValidator();

    assertEquals(true, validator.isValidInput("y"));
  }

  @Test
  public void testValidInputForNo() {
    Validator validator = new PlayAgainValidator();

    assertEquals(true, validator.isValidInput("N"));
  }

  @Test
  public void testInvalidInput() {
    Validator validator = new PlayAgainValidator();

    assertEquals(false, validator.isValidInput("t"));
  }

  @Test
  public void testInvalidInputForIntegers() {
    Validator validator = new PlayAgainValidator();

    assertEquals(false, validator.isValidInput("2"));
  }

}
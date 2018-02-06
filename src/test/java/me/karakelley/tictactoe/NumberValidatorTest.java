package me.karakelley.tictactoe;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumberValidatorTest {

  BoardState boardState = mock(BoardState.class);
  @Test
  public void testInputIsInvalid() {
    Validator validator = new NumberValidator(boardState);

    assertEquals(false, validator.isValidInput("-3"));
  }

  @Test
  public void testInputIsValid() {
    Validator validator = new NumberValidator(boardState);
    when(boardState.cellAvailable(4)).thenReturn(true);

    assertEquals(true, validator.isValidInput("4"));
  }

  @Test
  public void testInputIsInvalidForCharacters() {
    Validator validator = new NumberValidator(boardState);

    assertEquals(false, validator.isValidInput("f"));
  }

}
package me.karakelley.tictactoe;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberValidatorTest {

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

}
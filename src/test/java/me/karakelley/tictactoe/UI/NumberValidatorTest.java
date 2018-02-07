package me.karakelley.tictactoe.UI;

import me.karakelley.tictactoe.UI.validators.NumberValidator;
import me.karakelley.tictactoe.UI.validators.Validator;
import me.karakelley.tictactoe.game.BoardState;
import org.junit.jupiter.api.Test;

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

}
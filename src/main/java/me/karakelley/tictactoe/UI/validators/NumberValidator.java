package me.karakelley.tictactoe.UI.validators;

import me.karakelley.tictactoe.game.BoardState;

public class NumberValidator implements Validator {
  private BoardState boardState;

  public NumberValidator(BoardState boardState) {
    this.boardState = boardState;
  }

  @Override
  public boolean isValidInput(String input) {
    try {
      return boardState.cellAvailable(Integer.parseInt(input));
    } catch(IllegalArgumentException e) {
      return false;
    }
  }
}

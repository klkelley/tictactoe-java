package me.karakelley.tictactoe;

class NumberValidator implements Validator {
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

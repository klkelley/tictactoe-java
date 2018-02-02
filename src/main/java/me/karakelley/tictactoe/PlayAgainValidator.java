package me.karakelley.tictactoe;

public class PlayAgainValidator implements Validator{
  @Override
  public boolean isValidInput(String input) {
    try {
      return validAnswer(input);
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  private boolean validAnswer(String input) {
    return input.toLowerCase().equals("y") || input.toLowerCase().equals("n");
  }
}

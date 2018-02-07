package me.karakelley.tictactoe.UI.validators;

public class PlayerTypeValidator implements Validator {
  @Override
  public boolean isValidInput(String input) {
    try {
      return inBounds(Integer.parseInt(input));
    } catch(IllegalArgumentException e) {
      return false;
    }
  }

  private boolean inBounds(int choice) {
    return choice > 0 && choice < 5;
  }
}

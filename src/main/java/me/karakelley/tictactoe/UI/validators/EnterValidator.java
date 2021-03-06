package me.karakelley.tictactoe.UI.validators;

public class EnterValidator implements Validator {

  @Override
  public boolean isValidInput(String input) {
    try {
      return hitEnter(input);
    } catch(IllegalArgumentException e) {
      return false;
    }
  }

  private boolean hitEnter(String input) {
    return input.isEmpty();
  }
}

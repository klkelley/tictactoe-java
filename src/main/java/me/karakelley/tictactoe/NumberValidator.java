package me.karakelley.tictactoe;

class NumberValidator implements Validator {

  @Override
  public boolean isValidInput(String input) {
    try {
      return validNumber(Integer.parseInt(input));
    } catch(IllegalArgumentException e) {
      return false;
    }
  }

  private boolean validNumber(int number) {
    return number > 0 && number < 10;
  }

}

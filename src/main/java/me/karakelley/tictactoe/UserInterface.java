package me.karakelley.tictactoe;

public interface UserInterface {

  void greetUser();
  void displayWinner(boolean firstPlayerWins);
  String userPrompt(String message, Validator validator);
  void displayBoard(BoardState board);
  void displayMessage(String message);
  void displayTie();
  void clearScreen();
  String winningStatement(boolean firstPlayerWins);

}

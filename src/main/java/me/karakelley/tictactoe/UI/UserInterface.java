package me.karakelley.tictactoe.UI;

import me.karakelley.tictactoe.game.BoardState;
import me.karakelley.tictactoe.UI.validators.Validator;

public interface UserInterface {

  void greetUser();
  void displayWinner(boolean firstPlayerWins);
  String userPrompt(String message, Validator validator);
  void displayBoard(BoardState board);
  void displayMessage(String message);
  void displayTie();
  void clearScreen();
  void setWinMessage(String s);
  void setLoseMessage(String s);
}

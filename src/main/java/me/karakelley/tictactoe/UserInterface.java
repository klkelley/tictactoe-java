package me.karakelley.tictactoe;

import java.io.IOException;

public class UserInterface {
  private IO io;
  private BoardPresenter boardPresenter;

  public UserInterface(IO io, BoardPresenter boardPresenter) {
    this.io = io;
    this.boardPresenter = boardPresenter;
  }

  public void displayMessage(String message) {
    io.display(message);
  }

  public String userPrompt(String message, Validator validator) {
    String input;

    do {
      io.display(message);
      input = io.getInput();

    } while(!validator.isValidInput(input));
      return input;
  }

  public void waitForKeyPress() {
    try {
      io.anyKey();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void displayBoard(BoardState board) {
    io.display(boardPresenter.prettify(board.getGrid()));
  }
}

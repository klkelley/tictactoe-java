package me.karakelley.tictactoe;

import java.util.Arrays;
import java.util.Collections;

public class Game {

  private UserInterface userInterface;
  private HumanPlayer humanPlayer1;
  private HumanPlayer humanPlayer2;
  private BoardState boardState;
  private ValidatorFactory validator;
  private HumanPlayer[] players;

  public Game(UserInterface userInterface, HumanPlayer player1, HumanPlayer player2, BoardState boardState, ValidatorFactory validator) {
    this.userInterface = userInterface;
    this.humanPlayer1 = player1;
    this.humanPlayer2 = player2;
    this.boardState = boardState;
    this.validator = validator;
    this.players = setUpPlayerOrder();
  }

  public void start() {
    userInterface.greetUser();
    userInterface.userPrompt("Please press \"ENTER\" to continue\n", validator.make("EnterValidator"));
    userInterface.displayBoard(boardState.getGrid());

    play();
  }

  private void play() {
    while (!boardState.fullBoard()) {
      HumanPlayer player = takeTurn();
      String chosenCell = userInterface.userPrompt("Please enter an available cell:\n", validator.make("NumberValidator"));
      boardState.placeMove(chosenCell, player.getMarker());
      userInterface.displayBoard(boardState.getGrid());
    }
  }

  private HumanPlayer takeTurn() {
    Collections.reverse(Arrays.asList(players));
    return players[0];
  }

  private HumanPlayer[] setUpPlayerOrder() {
    HumanPlayer[] players = new HumanPlayer[2];
    players[0] = humanPlayer1;
    players[1] = humanPlayer2;
    return players;
  }

}

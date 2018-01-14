package me.karakelley.tictactoe;

import java.util.Arrays;
import java.util.Collections;

public class Game {

  private UserInterface userInterface;
  private HumanPlayer humanPlayer1;
  private HumanPlayer humanPlayer2;
  private BoardState boardState;
  private HumanPlayer[] players;
  private GameState gameState;

  public Game(UserInterface userInterface, HumanPlayer player1, HumanPlayer player2, BoardState boardState, GameState gameState) {
    this.userInterface = userInterface;
    this.humanPlayer1 = player1;
    this.humanPlayer2 = player2;
    this.boardState = boardState;
    this.players = setUpPlayerOrder();
    this.gameState = gameState;
  }

  public void start() {
    userInterface.displayMessage("Welcome to Tic Tac Toe!\n");
    userInterface.userPrompt("Please press \"ENTER\" to continue\n", new EnterValidator());
    userInterface.displayBoard(boardState);

    play();
  }

  private void play() {
    while (!gameState.gameOver(boardState)) {
      HumanPlayer player = takeTurn();
      String chosenCell = userInterface.userPrompt("Please enter an available cell:\n", new NumberValidator(boardState));
      boardState.placeMove(chosenCell, player.getMarker());
      userInterface.displayBoard(boardState);
    }
    if (gameState.tie(boardState)) {
      userInterface.displayMessage("It's a tie!");
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

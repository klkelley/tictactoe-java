package me.karakelley.tictactoe;

import java.util.Arrays;
import java.util.Collections;

public class GameLoop {

  private UserInterface userInterface;
  private HumanPlayer humanPlayer1;
  private HumanPlayer humanPlayer2;
  private HumanPlayer[] players;

  public GameLoop(UserInterface userInterface, HumanPlayer player1, HumanPlayer player2) {
    this.userInterface = userInterface;
    this.humanPlayer1 = player1;
    this.humanPlayer2 = player2;
    this.players = setUpPlayerOrder();
  }

  public void start(BoardState boardState, Game game) {
    userInterface.displayMessage("Welcome to Tic Tac Toe!\n");
    userInterface.userPrompt("Please press \"ENTER\" to continue\n", new EnterValidator());
    userInterface.displayBoard(boardState);

    play(boardState, game);
  }

  private void play(BoardState boardState, Game game) {
    while (!game.gameOver(boardState)) {
      HumanPlayer player = takeTurn();
      String chosenCell = userInterface.userPrompt("Please enter an available cell:\n", new NumberValidator(boardState));
      boardState.placeMove(chosenCell, player.getMarker());
      userInterface.displayBoard(boardState);
    }
    if (game.tie(boardState)) {
      userInterface.displayMessage("It's a tie!\n");
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

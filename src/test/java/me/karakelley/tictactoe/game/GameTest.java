package me.karakelley.tictactoe.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

  private Game game;
  BoardState boardState = new BoardState();

  @BeforeEach
  public void setUp() {
    game = new Game();
  }

  @Test
  public void testTie() {
    boardState.placeMove("0", "O");
    boardState.placeMove("1", "O");
    boardState.placeMove("2", "X");
    boardState.placeMove("3", "X");
    boardState.placeMove("4", "X");
    boardState.placeMove("5", "O");
    boardState.placeMove("6", "O");
    boardState.placeMove("7", "X");
    boardState.placeMove("8", "O");

    assertEquals(true, game.tie(boardState));
  }

  @Test
  public void testGameOver() {
    boardState.placeMove("0", "O");
    boardState.placeMove("1", "O");
    boardState.placeMove("2", "O");
    boardState.placeMove("3", "X");
    boardState.placeMove("4", "X");
    boardState.placeMove("5", "O");
    boardState.placeMove("6", "O");
    boardState.placeMove("7", "X");
    boardState.placeMove("8", "O");

    assertEquals(true, game.gameOver(boardState));
  }
}
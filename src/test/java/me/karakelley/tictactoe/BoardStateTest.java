package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardStateTest {

  @Test
  public void testPlaceMove() {
    BoardState boardState = new BoardState();
    String[] expectedOutput = new String[] {"X","-", "-", "-", "-", "-", "-", "-", "-"};
    assertArrayEquals(expectedOutput, boardState.placeMove("0", "X"));
  }

  @Test
  public void testBoardFull() {
    BoardState boardState = new BoardState(new String[]{"X", "O", "X", "O", "X", "O", "X", "O", "X"});

    assertEquals(true, boardState.fullBoard());
  }
}
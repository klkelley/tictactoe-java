package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardStateTest {
  BoardState boardState;

  @BeforeEach
  public void setUp() {
    boardState = new BoardState();
  }

  @Test
  public void getGrid() {
    String[] expectedOutput = new String[] {"-","-", "-", "-", "-", "-", "-", "-", "-"};
    assertArrayEquals(expectedOutput, boardState.getGrid());
  }

  @Test
  public void testPlaceMove() {
    String[] expectedOutput = new String[] {"X","-", "-", "-", "-", "-", "-", "-", "-"};
    assertArrayEquals(expectedOutput, boardState.placeMove("0", "X"));
  }

  @Test
  public void testBoardFull() {
    boardState.placeMove("0", "X");
    boardState.placeMove("1", "X");
    boardState.placeMove("2", "X");
    boardState.placeMove("3", "X");
    boardState.placeMove("4", "X");
    boardState.placeMove("5", "X");
    boardState.placeMove("6", "X");
    boardState.placeMove("7", "X");
    boardState.placeMove("8", "X");
    assertEquals(true, boardState.fullBoard());
  }

  @Test
  public void testCellIsAvailable() {
    assertEquals(true, boardState.cellAvailable(0));
  }

  @Test void testCellIsNotAvailable() {
    boardState.placeMove("0", "X");
    assertEquals(false, boardState.cellAvailable(0));
  }

  @Test
  public void testCombinations() {
    String[][] expectedOutput = new String[][]{ {"X","X", "X"},
                                                { "-", "-", "-"},
                                                { "-", "-", "-"},
                                                { "X", "-", "-"},
                                                { "X", "-", "-"},
                                                { "X", "-", "-"},
                                                { "X", "-", "-"},
                                                { "X", "-", "-"}};

    boardState.placeMove("0", "X");
    boardState.placeMove("1", "X");
    boardState.placeMove("2", "X");
    assertArrayEquals(expectedOutput, boardState.combinations());
  }
}
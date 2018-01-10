package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BoardPresenterTest {
  private BoardPresenter boardPresenter;

  BoardState boardState = new BoardState(new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"});

  @BeforeEach
  public void setUp() {
    boardPresenter = new BoardPresenter(boardState);
  }

  @Test
  public void testSetupBoard() {
    String[] blankGrid = new String[]{"-","-","-","-","-","-","-","-","-"};
    assertEquals(testBoardBuilder(blankGrid), boardPresenter.setupBoard());
  }

  @Test
  public void testBoardHasOneMarker() {
    boardState.placeMove(1);
    String[] testGrid = new String[]{"-","X","-","-","-","-","-","-","-"};
    assertEquals(testBoardBuilder(testGrid), boardPresenter.setupBoard());

  }

  private String testBoardBuilder(String[] grid) {
    StringBuilder board = new StringBuilder();
    String blankSpace = "   |   |   \n";
    String rowDivider = "___________\n";

    for (int i = 0; i < 3; i++){
      board.append(blankSpace);
      board.append(" %s | %s | %s \n");
      board.append(blankSpace);
      if (i < 2) {
        board.append(rowDivider);
      }
    }
    board.append("\n ");

    return String.format(board.toString(), boardGridBuilder(grid));
  }

  private String[] boardGridBuilder(String[] grid) {
    String[] newGrid = new String[9];
    for (int n = 0; n < grid.length; n++) {
      if (grid[n] == "-") {
        newGrid[n] = Integer.toString(n);
      } else {
        newGrid[n] = grid[n];
      }
    }
    return newGrid;
  }
}
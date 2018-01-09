package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardInterfaceTest {
  private BoardInterface boardInterface;

  @BeforeEach
  public void setUp() {
    boardInterface = new BoardInterface();
  }

  @Test
  public void testSetupBoard() {
    assertEquals(boardBuilder(), boardInterface.setupBoard());
  }


  private String boardBuilder() {
    StringBuilder board = new StringBuilder();
    String[] spaces = new String[]{"0","1","2","3","4","5","6","7","8"};
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

    return String.format(board.toString(), spaces);
  }
}
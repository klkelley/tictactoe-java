package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardInterfaceTest {
  private BoardInterface boardInterface;

  @BeforeEach
  public void setUp() {
    boardInterface = new BoardInterface();
  }

  @Test
  public void testSetupBoard() {
    assertEquals("   |   |   \n" +
                           " 0 | 1 | 2 \n" +
                           "   |   |   \n" +
                           "___________\n" +
                           "   |   |   \n" +
                           " 3 | 4 | 5 \n" +
                           "   |   |   \n" +
                           "___________\n" +
                           "   |   |   \n" +
                           " 6 | 7 | 8 \n" +
                           "   |   |   \n" +
                           "\n ", boardInterface.setupBoard());
  }
}
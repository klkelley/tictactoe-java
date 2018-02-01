package me.karakelley.tictactoe.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardPresenterTest {
  private BoardPresenter boardPresenter;

  @BeforeEach
  public void setUp() {
    boardPresenter = new BoardPresenter();
  }

  @Test
  public void testSetupBoard() {
    String[] blankGrid = new String[]{"-","-","-","-","-","-","-","-","-"};
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
                          "\n\n", boardPresenter.prettify(blankGrid));
  }

  @Test
  public void testBoardHasOneMarker() {
    String[] testGrid = new String[]{"-","X","-","-","-","-","-","-","-"};
    assertEquals("   |   |   \n" +
                          " 0 | X | 2 \n" +
                          "   |   |   \n" +
                          "___________\n" +
                          "   |   |   \n" +
                          " 3 | 4 | 5 \n" +
                          "   |   |   \n" +
                          "___________\n" +
                          "   |   |   \n" +
                          " 6 | 7 | 8 \n" +
                          "   |   |   \n" +
                          "\n\n", boardPresenter.prettify(testGrid));

  }
}
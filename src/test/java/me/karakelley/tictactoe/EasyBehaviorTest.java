package me.karakelley.tictactoe;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.spy;

public class EasyBehaviorTest {

  BoardState boardState = spy(new BoardState());
  Player player;

  @Before
  public void setUp() {
    player = new ComputerPlayer("X", new EasyBehavior());
  }

  @Test
  public void testMove() {
   int cell = Integer.parseInt(player.pickMove(boardState));
   assertTrue(cell < 9 );
  }

  @Test
  public void testChoseCellNotAlreadyTaken() {
    for (int i = 0; i < 100; i++) {
      boardState.placeMove("1", "O");
      boardState.placeMove("0", "X");
      boardState.placeMove("2", "O");
      boardState.placeMove("8", "O");
      int cell = Integer.parseInt(player.pickMove(boardState));
      assertTrue(cell > 2 && cell < 8);
    }
  }

  @Test
  public void testChoseLastCellAvailable() {
    for (int i = 0; i < 100; i++) {
      boardState.placeMove("1", "O");
      boardState.placeMove("0", "X");
      boardState.placeMove("8", "O");
      boardState.placeMove("2", "X");
      boardState.placeMove("3", "O");
      boardState.placeMove("5", "X");
      boardState.placeMove("6", "O");
      boardState.placeMove("7", "X");
      int cell = Integer.parseInt(player.pickMove(boardState));
      assertTrue(cell == 4);
    }
  }

}
package me.karakelley.tictactoe;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HumanPlayerTest {

  Player player;
  UserInterface UIMock = mock(HumanUserInterface.class);
  BoardState boardStateSpy = spy(new BoardState());
  Validator validatorMock = mock(NumberValidator.class);

  @Before
  public void setUp() {
    player = new HumanPlayer("X", UIMock);
  }

  @Test
  public void pickMove() {
    when(UIMock.userPrompt("\nPlease enter an available cell:\n", validatorMock)).thenReturn("3");
    player.pickMove(boardStateSpy);
    assertEquals("3", UIMock.userPrompt("\nPlease enter an available cell:\n", validatorMock));
   }

  @Test
  public void getMarker() {
    assertEquals("X", player.getMarker());
  }
}
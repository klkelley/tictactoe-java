package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanPlayerTest {

  Player player;
  UserInterface UIMock = mock(HumanUserInterface.class);
  BoardState boardStateSpy = spy(new BoardState());
  Validator validatorMock = mock(NumberValidator.class);

  @BeforeEach
  public void setUp() {
    player = new HumanPlayer("X", UIMock);
  }

  @Test
  void pickMove() {
    when(UIMock.userPrompt("\nPlease enter an available cell:\n", validatorMock)).thenReturn("3");
    player.pickMove(boardStateSpy);
    assertEquals("3", UIMock.userPrompt("\nPlease enter an available cell:\n", validatorMock));
   }

  @Test
  void getMarker() {
    assertEquals("X", player.getMarker());
  }
}
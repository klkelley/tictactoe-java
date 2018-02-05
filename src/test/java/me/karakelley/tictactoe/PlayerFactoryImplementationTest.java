package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlayerFactoryImplementationTest {

  UserInterface UImock = mock(HumanUserInterface.class);
  Game gameMock = mock(Game.class);

  @Test
  public void testMakePlayer() {
    Player player = new PlayerFactoryImplementation(UImock, gameMock).makePlayer("1", "x", "O");
    assertTrue(player instanceof HumanPlayer);
  }

  @Test
  public void testMakeComputerPlayer() {
    Player player = new PlayerFactoryImplementation(UImock, gameMock).makePlayer("2", "X", "O");
    assertTrue(player instanceof ComputerPlayer);
  }

}
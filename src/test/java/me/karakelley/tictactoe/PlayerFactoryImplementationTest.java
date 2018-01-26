package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PlayerFactoryImplementationTest {

  UserInterface UImock = mock(HumanUserInterface.class);

  @Test
  public void testMakePlayer() {
    Player player = new PlayerFactoryImplementation(UImock).makePlayer("1", "x");
    assertTrue(player instanceof HumanPlayer);
  }

  @Test
  public void testMakeComputerPlayer() {
    Player player = new PlayerFactoryImplementation(UImock).makePlayer("2", "X");
    assertTrue(player instanceof ComputerPlayer);
  }

}
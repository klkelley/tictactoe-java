package me.karakelley.tictactoe.players;

import me.karakelley.tictactoe.UI.HumanUserInterface;
import me.karakelley.tictactoe.UI.UserInterface;

import me.karakelley.tictactoe.game.Game;
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
  public void testMakeEasyComputerPlayer() {
    Player player = new PlayerFactoryImplementation(UImock, gameMock).makePlayer("2", "X", "O");
    assertTrue(player instanceof ComputerPlayer);
  }

  @Test
  public void testMakeHardComputer() {
    Player player = new PlayerFactoryImplementation(UImock, gameMock).makePlayer("3", "X", "O");
    assertTrue(player instanceof ComputerPlayer);
  }

  @Test
  public void testMakeImpossibleComputer() {
    Player player = new PlayerFactoryImplementation(UImock, gameMock).makePlayer("4", "X", "O");
    assertTrue(player instanceof ComputerPlayer);
  }

}
package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryImplementationTest {


  @Test
  public void testMakePlayer() {
    Player player = new PlayerFactoryImplementation().makePlayer("1", "x");
    assertTrue(player instanceof HumanPlayer);
  }
}
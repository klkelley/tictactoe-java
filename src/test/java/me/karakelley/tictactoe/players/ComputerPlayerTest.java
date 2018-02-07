package me.karakelley.tictactoe.players;

import me.karakelley.tictactoe.players.ArtificialIntelligenceBehaviors.EasyBehavior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

  @Test
  public void testComputerHasMarker() {
    ComputerPlayer computerPlayer = new ComputerPlayer("X", new EasyBehavior());
    assertEquals("X", computerPlayer.getMarker());
  }

}
package me.karakelley.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

  @Test
  public void testComputerHasMarker() {
    ComputerPlayer computerPlayer = new ComputerPlayer("X", new EasyBehavior());
    assertEquals("X", computerPlayer.getMarker());
  }

}
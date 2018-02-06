package me.karakelley.tictactoe;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {

  @Test
  public void testComputerHasMarker() {
    ComputerPlayer computerPlayer = new ComputerPlayer("X", new EasyBehavior());
    assertEquals("X", computerPlayer.getMarker());
  }

}
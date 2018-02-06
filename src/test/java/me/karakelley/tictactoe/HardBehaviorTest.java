package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HardBehaviorTest {
  private BoardState boardState = new BoardState();
  private Player player;

  @BeforeEach
  public void setUp() {
    player = new ComputerPlayer("O", new HardBehavior("X"));
  }

  @Test
  public void test_blocks_a_winning_top_row() {
    boardState.placeMove("0", "X");
    boardState.placeMove("1", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 2);
  }

  @Test
  public void test_blocks_a_winning_middle_row() {
    boardState.placeMove("3", "X");
    boardState.placeMove("5", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 4);
  }

  @Test
  public void test_blocks_a_winning_bottom_row() {
    boardState.placeMove("7", "X");
    boardState.placeMove("8", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 6);
  }

  @Test
  public void test_blocks_a_winning_column() {
    boardState.placeMove("0", "X");
    boardState.placeMove("3", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 6);
  }

  @Test
  public void test_blocks_winning_middle_column() {
    boardState.placeMove("1", "X");
    boardState.placeMove("7", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 4);
  }

  @Test
  public void test_blocks_a_winning_diagonal() {
    boardState.placeMove("0", "X");
    boardState.placeMove("4", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 8);
  }

  @Test
  public void test_blocks_a_winning_right_diagonal() {
    boardState.placeMove("6", "X");
    boardState.placeMove("4", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 2);
  }

  @Test
  public void test_computer_blocks_winning_row() {
    boardState.placeMove("0", "X");
    boardState.placeMove("6", "O");
    boardState.placeMove("4", "X");
    boardState.placeMove("8", "O");
    boardState.placeMove("7", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 1);
  }

  @Test
  public void test_computer_blocks_winning_diagonal() {
    boardState.placeMove("6", "X");
    boardState.placeMove("5", "O");
    boardState.placeMove("8", "X");
    boardState.placeMove("7", "O");
    boardState.placeMove("4", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell == 2 || cell == 0);
  }

  @Test
  public void test_computer_picks_at_random_when_no_block_needed() {
    boardState.placeMove("0", "X");
    int cell = Integer.parseInt(player.pickMove(boardState));
    assertTrue(cell > 0);
  }
}
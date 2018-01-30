package me.karakelley.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ImpossibleBehaviorTest {

  final static String COMPUTER_MARKER = "O";
  final static String OPPONENT_MARKER = "X";
  BoardState boardState = new BoardState();
  Game game = new Game();
  UserInterface userInterfaceMock = mock(UserInterface.class);
  GameLoop autoGame;
  GameLoop simulatedGame;
  Player impossiblePlayer;
  Player opponent;


  @BeforeEach
  public void setUp() {
    impossiblePlayer = new ComputerPlayer(COMPUTER_MARKER, new ImpossibleBehavior(COMPUTER_MARKER, OPPONENT_MARKER, game));
    opponent = new ComputerPlayer(OPPONENT_MARKER, new EasyBehavior());
    autoGame = new GameLoop(userInterfaceMock, opponent, impossiblePlayer);
    simulatedGame = new GameLoop(userInterfaceMock, impossiblePlayer, opponent);
  }

  @RepeatedTest(10)
  public void test_impossible_computer_always_wins() {
    autoGame.start(boardState, game);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER) );
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cells_zero_and_two() {
    boardState.placeMove("0", OPPONENT_MARKER);
    boardState.placeMove("4", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    simulatedGame.start(boardState, game);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER) );
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cells_zero_two_six() {
    boardState.placeMove("0", OPPONENT_MARKER);
    boardState.placeMove("4", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    boardState.placeMove("1", COMPUTER_MARKER);
    boardState.placeMove("6", OPPONENT_MARKER);
    simulatedGame.start(boardState, game);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER)  );
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cells_zero_two_six_seven() {
    boardState.placeMove("0", OPPONENT_MARKER);
    boardState.placeMove("4", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    boardState.placeMove("1", COMPUTER_MARKER);
    boardState.placeMove("6", OPPONENT_MARKER);
    boardState.placeMove("3", COMPUTER_MARKER);
    boardState.placeMove("7", OPPONENT_MARKER);
    simulatedGame.start(boardState, game);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER));
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cell_four_first() {
    boardState.placeMove("4", OPPONENT_MARKER);
    boardState.placeMove("0", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    simulatedGame.start(boardState, game);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER));
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cell_four_three_two() {
    boardState.placeMove("4", OPPONENT_MARKER);
    boardState.placeMove("0", COMPUTER_MARKER);
    boardState.placeMove("3", OPPONENT_MARKER);
    boardState.placeMove("5", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    simulatedGame.start(boardState, game);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER));
  }

}
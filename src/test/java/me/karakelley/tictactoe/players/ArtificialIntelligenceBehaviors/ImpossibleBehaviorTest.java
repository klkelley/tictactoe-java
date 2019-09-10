package me.karakelley.tictactoe.players.ArtificialIntelligenceBehaviors;

import me.karakelley.tictactoe.UI.UserInterface;
import me.karakelley.tictactoe.game.BoardState;
import me.karakelley.tictactoe.game.Game;
import me.karakelley.tictactoe.game.GameLoop;
import me.karakelley.tictactoe.players.ComputerPlayer;
import me.karakelley.tictactoe.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ImpossibleBehaviorTest {

  final static String COMPUTER_MARKER = "O";
  final static String OPPONENT_MARKER = "X";
  Game game = new Game();
  BoardState boardState = new BoardState();
  UserInterface userInterfaceMock = mock(UserInterface.class);
  GameLoop autoGame;
  GameLoop simulatedGame;
  Player impossiblePlayer;
  Player opponent;


  @BeforeEach
  public void setUp() {
    impossiblePlayer = new ComputerPlayer(COMPUTER_MARKER, new ImpossibleBehavior(COMPUTER_MARKER, OPPONENT_MARKER, game));
    opponent = new ComputerPlayer(OPPONENT_MARKER, new EasyBehavior());
    simulatedGame = new GameLoop(userInterfaceMock, impossiblePlayer, opponent);
  }

  @Test
  public void test_impossible_computer_always_wins() throws ExecutionException, InterruptedException {
    Integer count = 10;
    Integer processors = Runtime.getRuntime().availableProcessors();
    ExecutorService threadPool = Executors.newFixedThreadPool(processors);
    List<Future<Boolean>> runningGames = new ArrayList<>();

    for (int i = 0; i < count; i ++) {
      Future<?> runningGame = threadPool.submit(() -> {
        Game newGame = new Game();
        BoardState newBoardState = new BoardState();
        impossiblePlayer = new ComputerPlayer(COMPUTER_MARKER, new ImpossibleBehavior(COMPUTER_MARKER, OPPONENT_MARKER, newGame));
        autoGame = new GameLoop(userInterfaceMock, opponent, impossiblePlayer);
        autoGame.start(newGame, newBoardState);
        return newGame.tie(newBoardState) || newGame.winningPlayer().equals(COMPUTER_MARKER);
      });
      runningGames.add((Future<Boolean>) runningGame);
    }

    for (int i = 0; i < runningGames.size(); i++) {
      Future<Boolean> finishedGames = runningGames.get(i);
      Boolean gameWonOrTied = finishedGames.get();
      assertTrue(gameWonOrTied.equals(true));
    }
  }

  @Test

  public void test_impossible_computer_wins_when_human_picks_cells_zero_and_two() {
    boardState.placeMove("0", OPPONENT_MARKER);
    boardState.placeMove("4", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    simulatedGame.start(game, boardState);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER) );
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cells_zero_two_six() {
    boardState.placeMove("0", OPPONENT_MARKER);
    boardState.placeMove("4", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    boardState.placeMove("1", COMPUTER_MARKER);
    boardState.placeMove("6", OPPONENT_MARKER);
    simulatedGame.start(game, boardState);

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
    simulatedGame.start(game, boardState);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER));
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cell_four_first() {
    boardState.placeMove("4", OPPONENT_MARKER);
    boardState.placeMove("0", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    simulatedGame.start(game, boardState);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER));
  }

  @Test
  public void test_impossible_computer_wins_when_human_picks_cell_four_three_two() {
    boardState.placeMove("4", OPPONENT_MARKER);
    boardState.placeMove("0", COMPUTER_MARKER);
    boardState.placeMove("3", OPPONENT_MARKER);
    boardState.placeMove("5", COMPUTER_MARKER);
    boardState.placeMove("2", OPPONENT_MARKER);
    simulatedGame.start(game, boardState);

    assertTrue(game.tie(boardState) || game.winningPlayer().equals(COMPUTER_MARKER));
  }

}
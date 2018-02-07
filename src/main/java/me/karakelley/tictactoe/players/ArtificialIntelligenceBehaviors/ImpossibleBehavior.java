package me.karakelley.tictactoe.players.ArtificialIntelligenceBehaviors;

import me.karakelley.tictactoe.game.BoardState;
import me.karakelley.tictactoe.game.Game;

import java.util.*;

public class ImpossibleBehavior implements AIBehavior {
  private String[] players;
  private Game game;

  public ImpossibleBehavior(String opponentMarker, String computerMarker, Game game) {
    this.game = game;
    this.players = new String[]{opponentMarker, computerMarker};
  }

  @Override
  public String move(BoardState boardState) {
    return String.valueOf(minimax(boardState, 0, new HashMap<>()));
  }

  public int minimax(BoardState boardState, int depth, Map<Integer, Integer> scores) {
    if (game.tie(boardState)) {
      return 0;
    } else if (game.gameOver(boardState)) {
      return -1;
    }

    for (int space : boardState.availableCells()) {
      placeMove(boardState, String.valueOf(space));
      scores.putIfAbsent(space, (-1 * minimax(boardState, depth + 1, new HashMap<>())));
      resetSpace(boardState, String.valueOf(space));
    }
    return depth == 0 ? bestMove(scores) : highestScore(scores);
  }

  private void resetSpace(BoardState boardState, String space) {
    boardState.placeMove(space, space.toString());
  }

  private void placeMove(BoardState boardState, String space) {
    boardState.placeMove(space, takeTurn(boardState));
  }

  private int highestScore(Map<Integer, Integer> scores) {
    return scores.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
  }

  private int bestMove(Map<Integer, Integer> scores) {
    return scores.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
  }

  private String takeTurn(BoardState boardState) {
    return boardState.availableCells().size() % 2 == 1 ? players[1] : players[0];
  }
}

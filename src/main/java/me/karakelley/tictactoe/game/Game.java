package me.karakelley.tictactoe.game;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
  public String winningPlayer;

  public boolean gameOver(BoardState boardState) {
    return tie(boardState) || winner(boardState);
  }

  public boolean tie(BoardState boardState) {
    return boardState.fullBoard() && !winner(boardState);
  }


  private boolean winner(BoardState boardState) {
    boolean winner = false;
    String[][] combos = boardState.winningCombinations();
    for (String[] combo : combos) {
      if (uniqueMarker(combo) && isMarker(combo)) {
        winner = true;
        winningPlayer = getUniqueMarker(combo);
      }
    }
    return winner;
  }

  private String getUniqueMarker(String[] section) {
    return section[0];
  }

  private boolean uniqueMarker(String[] section) {
    return removeDuplicates(section).size() == 1;
  }

  private boolean isMarker(String[] section) {
    return removeDuplicates(section).get(0).matches("[A-Z]");
  }

  private List<String> removeDuplicates(String[] combinations){
    List<String> combos = Arrays.asList(combinations);
    return combos.
            stream().
            distinct().
            collect(Collectors.toList());
  }

  public String winningPlayer() {
    return winningPlayer;
  }
}

package me.karakelley.tictactoe;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

  public boolean gameOver(BoardState boardState) {
    return tie(boardState) || winner(boardState);
  }

  public boolean tie(BoardState boardState) {
    return boardState.fullBoard() && !winner(boardState);
  }

  private boolean winner(BoardState boardState) {
    boolean winner = false;
    String pattern = "[A-Z]";
    String[][] combos = boardState.winningCombinations();
    for (String[] combo : combos) {
      List<String> section = removeDuplicates(combo);
      if (section.size() == 1 && section.get(0).matches(pattern)) {
        winner = true;
      }
    }
    return winner;
  }

  private List<String> removeDuplicates(String[] combinations){
    List<String> combos = Arrays.asList(combinations);
    return combos.
            stream().
            distinct().
            collect(Collectors.toList());
  }
}

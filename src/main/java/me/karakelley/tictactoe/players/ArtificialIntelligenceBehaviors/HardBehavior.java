package me.karakelley.tictactoe.players.ArtificialIntelligenceBehaviors;

import me.karakelley.tictactoe.game.BoardState;

import java.util.*;
import java.util.stream.Collectors;

public class HardBehavior implements AIBehavior{
  private String opponentMarker;

  public HardBehavior(String opponentMarker) {
    this.opponentMarker = opponentMarker;
  }

  public String move(BoardState boardState) {
    if (blockNeeded(boardState.winningCombinations()) && searchForBlankCell(boardState.winningCombinations()) != null) {
      return searchForBlankCell(boardState.winningCombinations());
    } else {
      return availableCells(boardState).get(randomCell(boardState)).toString();
    }
  }

  private boolean blockNeeded(String[][] section) {
    for (String[] aSection : section) {
      if (twoInARow(aSection)) {
        return true;
      }
    }
    return false;
  }

  private String searchForBlankCell(String[][] section) {
    for (String[] aSection : section) {
      if (foundBlankCell(aSection)) {
        return retrieveCell(aSection);
      }
    }
    return null;
  }

  private String retrieveCell(String[] section) {
    return Collections.singletonList(checkForBlankCell(section).get(0)).get(0);
  }

  private boolean twoInARow(String[] section) {
    return checkForOpponentMarker(section).length == section.length - 1;
  }

  private boolean foundBlankCell(String[] section) {
    return twoInARow(section) && checkForBlankCell(section).size() == 1;
  }

  private List<String> checkForBlankCell(String[] section) {
    return Arrays.stream(section)
            .filter(space -> space.matches("[0-9]+"))
            .collect(Collectors.toList());
  }

  private Object[] checkForOpponentMarker(String[] section) {
    return Arrays.stream(section)
            .filter(marker -> marker.equals(opponentMarker))
            .toArray();
  }

  private int randomCell(BoardState boardState) {
    Random generator = new Random();
    return generator.nextInt(availableCells(boardState).size());
  }

  private List<Integer> availableCells(BoardState boardState) {
    return boardState.availableCells();
  }
}


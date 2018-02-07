package me.karakelley.tictactoe.UI;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

  private JSONParser jsonParser = new JSONParser();
  private Parser parser;

  @BeforeEach
  public void setUp() throws IOException, ParseException {
    parser = new Parser(new FileReader("src/test/resources/config.json"), jsonParser);
  }

  @Test
  public void testGetValuesofPlayerOne() {
    assertEquals("Q", parser.getValues("markers", "playerOne"));
  }

  @Test
  public void testGetValuesofPlayerTwo() {
    assertEquals("Z", parser.getValues("markers", "playerTwo"));
  }
}
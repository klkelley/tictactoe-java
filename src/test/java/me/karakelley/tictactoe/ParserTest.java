package me.karakelley.tictactoe;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class ParserTest {

  private JSONParser jsonParser = new JSONParser();
  private Parser parser;

  @Before
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
package me.karakelley.tictactoe;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

  private JSONParser jsonParser = new JSONParser();
  private Parser parser;

  @BeforeEach
  public void setUp() throws IOException, ParseException {
    parser = new Parser(new FileReader("/Users/karakelley/IdeaProjects/tictactoe/src/test/resources/config.json"), jsonParser);
  }

  @Test
  public void getMarkers() throws IOException, ParseException {
    Collection<String> expectedOutput = new ArrayList<>(Arrays.asList("Z", "Q"));
    assertEquals(expectedOutput, parser.markers());
  }

  @Test
  public void testFirstMaker() throws IOException, ParseException {
    assertEquals("Q", parser.firstMarker());
  }

  @Test
  public void testSecondMarker() throws IOException, ParseException {
    assertEquals("Z", parser.secondMarker());
  }

}
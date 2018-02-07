package me.karakelley.tictactoe.UI;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Parser {
  private Reader filename;
  private JSONParser jsonParser;
  JSONObject jsonObject;

  public Parser(FileReader filename, JSONParser jsonParser) throws IOException, ParseException {
    this.filename = filename;
    this.jsonParser = jsonParser;
    this.jsonObject = convertFileToJsonObject();
  }

  public String getValues(String markers, String player) {
    JSONObject parent = (JSONObject)jsonObject.get(markers);
    return (String) parent.get(player);
  }

  private Object parseFile() throws IOException, ParseException {
    return jsonParser.parse(filename);
  }

  private JSONObject convertFileToJsonObject() throws IOException, ParseException {
    return (JSONObject) parseFile();
  }
}

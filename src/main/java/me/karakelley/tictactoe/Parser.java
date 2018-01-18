package me.karakelley.tictactoe;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Parser {
  private Reader filename;
  private JSONParser jsonParser;
  JSONObject jsonObject;

  public Parser(FileReader filename, JSONParser jsonParser) throws IOException, ParseException {
    this.filename = filename;
    this.jsonParser = jsonParser;
    this.jsonObject = convertFileToJsonObject();
  }


  public String firstMarker() throws IOException, ParseException {
    return markers().get(1);
  }

  public String secondMarker() throws IOException, ParseException {
    return markers().get(0);
  }

  public ArrayList<String> markers() throws IOException, ParseException {
    JSONObject markers = (JSONObject)jsonObject.get("markers");
    return new ArrayList<>(markers.values());
  }

  private Object parseFile() throws IOException, ParseException {
    return jsonParser.parse(filename);
  }

  private JSONObject convertFileToJsonObject() throws IOException, ParseException {
    return (JSONObject) parseFile();
  }
}

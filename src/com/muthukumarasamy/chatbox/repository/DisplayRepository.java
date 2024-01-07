package com.muthukumarasamy.chatbox.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DisplayRepository {

	private static final String DISPLAY_FILE = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\chatbox\\files\\display.json";
	private static DisplayRepository display = null;
	private JSONArray jsonArray;

	public static DisplayRepository getInstance() {
		if (display == null)
			display = new DisplayRepository();
		return display;

	}

	public JSONArray getDisplay(String string) throws FileNotFoundException, IOException, ParseException {
		JSONParser par = new JSONParser();
		JSONObject obj = (JSONObject) par.parse(new FileReader(DISPLAY_FILE));
		JSONArray arr = (JSONArray) obj.get(string);
		return arr;
	}

}

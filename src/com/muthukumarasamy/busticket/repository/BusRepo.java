package com.muthukumarasamy.busticket.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.busticket.dto.Bus;

public class BusRepo {

	public static final String BUS = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\busticket\\files\\BUS.json";

	public static BusRepo busrepo = null;
	List<Bus> buslist = new ArrayList<>();

	public static BusRepo getInstance() {

		if (busrepo == null)
			busrepo = new BusRepo();
		return busrepo;
	}

	private BusRepo() {

		loadfromjson();
	}

	private void loadfromjson() {

		try {
			String content = new String(Files.readAllBytes(Paths.get(BUS)));
			JSONArray jsonarray = new JSONArray(content);
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jsonobject = (JSONObject) jsonarray.get(i);
				String busname = jsonobject.getString("BusName");

				List<List<String>> seats = new ArrayList<>();
				JSONArray seatsArray = jsonobject.getJSONArray("Seating");
				for (int j = 0; j < seatsArray.length(); j++) {
					JSONArray seatGroupArray = seatsArray.getJSONArray(j);

					List<String> seatGroup = new ArrayList<>();
					for (int k = 0; k < seatGroupArray.length(); k++) {
						seatGroup.add(seatGroupArray.getString(k));
					}

					seats.add(seatGroup);
				}
				buslist.add(new Bus(busname, seats));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void savetojson() {

		JSONArray BusArray = new JSONArray();
		for (Bus details : buslist) {
			JSONObject jsonobject = new JSONObject();
			jsonobject.put("BusName", details.getBusName());
			JSONArray seatArray = new JSONArray();
			for (List<String> arr : details.getSeating()) {
				JSONArray innerArray = new JSONArray();
				for (int i = 0; i < arr.size(); i++) {
					innerArray.put(arr.get(i));
				}
				seatArray.put(innerArray);
			}
			jsonobject.put("Seating", seatArray);
			
			BusArray.put(jsonobject);
		}
		try (FileWriter filewriter = new FileWriter(BUS)) {
			filewriter.write(BusArray.toString(2));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Bus> getBusList() {
		return buslist;
	}

	public void setBusList(List<Bus> Buslist) {
		buslist = Buslist;
		savetojson();
	}

}

package com.muthukumarasamy.busticketbooking.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.busticketbooking.dto.Arrangement;
import com.muthukumarasamy.busticketbooking.dto.Booking;

public class Repository {

	private static List<Arrangement> bus = new ArrayList<>();
	private static List<Booking> bookings = new ArrayList<>();
	private static Repository repository = null;

	private static final String BOOKING = "C:\\Users\\ramki\\eclipse-workspace\\projects\\src\\com\\muthukumarasamy\\busticketbooking\\BOOKING.json";
	private static final String SEATS = "C:\\Users\\ramki\\eclipse-workspace\\projects\\src\\com\\muthukumarasamy\\busticketbooking\\ARRANGEMENT.json";

	private Repository() {
		loadbusFromJson();
		loadBookingFromJson();

	}

	public static Repository getInstance() {

		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public void loadbusFromJson() {
		try {
			String content = new String(Files.readAllBytes(Paths.get(SEATS)));
			JSONArray jsonArray = new JSONArray(content);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonobject = (JSONObject) jsonArray.get(i);
				String name = jsonobject.getString("name");
				String price = jsonobject.getString("amount");
				String dtime = jsonobject.getString("departureTime");

				List<List<String>> seats = new ArrayList<>();
				JSONArray seatsArray = jsonobject.getJSONArray("seats");
				for (int j = 0; j < seatsArray.length(); j++) {
					JSONArray seatGroupArray = seatsArray.getJSONArray(j);

					List<String> seatGroup = new ArrayList<>();
					for (int k = 0; k < seatGroupArray.length(); k++) {
						seatGroup.add(seatGroupArray.getString(k));
					}

					seats.add(seatGroup);
				}
				bus.add(new Arrangement(name, price, dtime, seats));

			}
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void savebustoJson() {

		JSONArray BusArray = new JSONArray();
		for (Arrangement details : bus) {
			JSONObject jsonobject = new JSONObject();
			jsonobject.put("name", details.getBusName());
			jsonobject.put("amount", details.getPrice());
			jsonobject.put("departureTime", details.getDepartureTime());
			JSONArray seatArray = new JSONArray();
			for (List<String> arr : details.getSeating()) {
				JSONArray innerArray = new JSONArray();
				for (int i = 0; i < arr.size(); i++) {
					innerArray.put(arr.get(i));
				}
				seatArray.put(innerArray);
			}
			jsonobject.put("seats", seatArray);
			BusArray.put(jsonobject);
		}
		try (FileWriter filewriter = new FileWriter(SEATS)) {
			filewriter.write(BusArray.toString());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void loadBookingFromJson() {
		try {
			String content = new String(Files.readAllBytes(Paths.get(BOOKING)));
			JSONArray jsonArray = new JSONArray(content);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonobject = (JSONObject) jsonArray.get(i);
				String name = jsonobject.getString("name");
				String age = jsonobject.getString("age");
				String seats = jsonobject.getString("seats");
				String bus = jsonobject.getString("bus");

				Booking book = new Booking(name, age, bus, seats);
				bookings.add(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveBookingToJson() {
		JSONArray jsonarray = new JSONArray();
		for (Booking book : bookings) {
			JSONObject jsonobject = new JSONObject();
			jsonobject.put("name", book.getUserName());
			jsonobject.put("age", book.getAge());
			jsonobject.put("bus", book.getBus());
			jsonobject.put("seats", book.getSeats());
			jsonarray.put(jsonobject);
		}
		try (FileWriter filepath = new FileWriter(BOOKING)) {
			filepath.write(jsonarray.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Arrangement> getBus() {
		return bus;
	}

	public void addBooking(Booking book) {
		bookings.add(book);
		saveBookingToJson();

	}

	public List<Booking> getBooking() {
		// TODO Auto-generated method stub
		return bookings;
	}

	public void removeBooking(int index) {
		bookings.remove(index);
		saveBookingToJson();
	}

	public void replaceBus(List<Arrangement> data) {
		bus = data;
		savebustoJson();
	}
}

package com.muthukumarasamy.busticket.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.busticket.dto.Ticket;

public class TicketRepo {

	private static final String TICKET = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\busticket\\files\\TICKET.json";
	private static TicketRepo ticketrepo = null;
	private static List<Ticket> ticketlist = new ArrayList<>();

	public static TicketRepo getInstance() {

		if (ticketrepo == null)
			ticketrepo = new TicketRepo();
		return ticketrepo;
	}

	public TicketRepo() {
		loadfromjson();

	}

	private void loadfromjson() {

		try {
			String content = new String(Files.readAllBytes(Paths.get(TICKET)));
			JSONArray jsonarray = new JSONArray(content);
			for (int i = 0; i < jsonarray.length(); i++) {

				JSONObject jsonobject = (JSONObject) jsonarray.get(i);
				String username = jsonobject.getString("UserName");
				String date = jsonobject.getString("Date");
				String arrival = jsonobject.getString("Arrival");
				String departure = jsonobject.getString("Departure");
				String price = jsonobject.getString("Price");
				String busname = jsonobject.getString("BusName");
				String seats = jsonobject.getString("Seats");
				String Status =jsonobject.getString("Status");
				ticketlist.add(new Ticket(username, date, arrival, departure, price, busname, seats,Status));
			}
		} catch (IOException e) {
			e.printStackTrace();
	}
	}

	public void savetojson() {
		JSONArray jsonarray = new JSONArray();
		for (Ticket ticket : ticketlist) {

			JSONObject jsonobject = new JSONObject();
			jsonobject.put("UserName", ticket.getUserName());
			jsonobject.put("Date", ticket.getDate());
			jsonobject.put("Arrival", ticket.getArrival());
			jsonobject.put("Departure", ticket.getDeparture());
			jsonobject.put("Price", ticket.getPrice());
			jsonobject.put("BusName", ticket.getBusName());
			jsonobject.put("Seats", ticket.getSeats());
			jsonobject.put("Status",ticket.getStatus());
			jsonarray.put(jsonobject);
		}
		try (FileWriter filewriter = new FileWriter(TICKET)) {
			filewriter.write(jsonarray.toString(2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Ticket> getTicketlist() {
		return ticketlist;
	}

	public void setTicketList(List<Ticket> ticketList) {
		ticketlist = ticketList;
		savetojson();

	}
}

package com.muthukumarasamy.busticket.bookticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.muthukumarasamy.busticket.dto.Bus;
import com.muthukumarasamy.busticket.repository.BusRepo;
import com.muthukumarasamy.busticket.repository.TicketRepo;
import com.muthukumarasamy.busticket.repository.UserRepo;
import com.muthukumarasamy.busticket.dto.Ticket;

public class BookticktetViewModel {

	List<Bus> buslist = new ArrayList<>();

	public List<String[]> getbusstands() {

		return UserRepo.getInstance().readCSV();
	}

	public Bus getBus(int index) {

		buslist = BusRepo.getInstance().getBusList();
		return buslist.get(index);
	}

	public void addtoTicketlist(Ticket ticket) {
		List<Ticket> ticketlist = TicketRepo.getInstance().getTicketlist();
		ticketlist.add(ticket);
		TicketRepo.getInstance().setTicketList(ticketlist);
	}

	public void removeSeats(String booked, Bus bus) {
		List<String> bookedSeat = Arrays.asList(booked.split(","));
		boolean found = false;
		for (List<String> row : bus.getSeating()) {
			for (int i = 0; i < row.size(); i++) {
				if (bookedSeat.contains(row.get(i))) {
					row.set(i, "0");
					found = true;
				}
			}
		}
	
		for (Bus userbus : buslist) {
			if (userbus.getBusName().equals(bus.getBusName())) {
				userbus.setSeating(bus.getSeating());
				break;		
			}
		}
		BusRepo.getInstance().setBusList(buslist);
	}
}

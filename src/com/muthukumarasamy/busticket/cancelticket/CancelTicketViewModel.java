package com.muthukumarasamy.busticket.cancelticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.muthukumarasamy.busticket.dto.Bus;
import com.muthukumarasamy.busticket.dto.Ticket;
import com.muthukumarasamy.busticket.dto.User;
import com.muthukumarasamy.busticket.repository.BusRepo;
import com.muthukumarasamy.busticket.repository.TicketRepo;
import com.muthukumarasamy.busticket.util.CurrentTickets;

public class CancelTicketViewModel extends CurrentTickets{

	List<Ticket> ticketlist = new ArrayList<>();

	public boolean cancelticket(Ticket ticket) {

		ticket.setStatus("Cancelled");
		replacetickets(ticket.getBusName(),ticket.getSeats());
		
		return false;
		
	}

	private void replacetickets(String busname, String seats) {

		List<Bus> buslist = BusRepo.getInstance().getBusList();
		for (Bus bus : buslist) {
			if (bus.getBusName().equals(busname)) {
				bus.setSeating(changetickets(bus.getSeating(), seats));

			}

		}
		
		BusRepo.getInstance().setBusList(buslist);
	}

	private List<List<String>> changetickets(List<List<String>> seating, String seats) {

		List<String> bookedseats = Arrays.asList(seats.split(","));
		for (String seat : bookedseats) {
			int row = seat.charAt(0) - 'a';
			int col = seat.charAt(1) - '1';

			List<String> inner = seating.get(row);
			inner.set(col, seat);
			seating.set(row, inner);
		}
		return seating;

	}

}

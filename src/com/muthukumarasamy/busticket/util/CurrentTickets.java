package com.muthukumarasamy.busticket.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.muthukumarasamy.busticket.dto.Ticket;
import com.muthukumarasamy.busticket.repository.TicketRepo;

public class CurrentTickets {

	public List<Ticket> getTicket(String username) {

		List<Ticket> ticketlist = TicketRepo.getInstance().getTicketlist();
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String todaydates = today.format(formatter);
		List<Ticket> userticket = new ArrayList<>();
		for (Ticket ticket : ticketlist) {

			if (ticket.getDate().compareTo(todaydates) < 0) {
				ticket.setStatus("Completed");
			}
			if (ticket.getUserName().equals(username) && ticket.getDate().compareTo(todaydates) >= 0
					&& ticket.getStatus().equals("OnProcess"))
				userticket.add(ticket);
		}
		return userticket;
	}

	public List<Ticket> getHistory(String username) {

		List<Ticket> ticketlist = TicketRepo.getInstance().getTicketlist();
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String todaydates = today.format(formatter);
		List<Ticket> userticket = new ArrayList<>();
		for (Ticket ticket : ticketlist) {

			if (ticket.getUserName().equals(username))
				userticket.add(ticket);
		}
		return userticket;
	}
}

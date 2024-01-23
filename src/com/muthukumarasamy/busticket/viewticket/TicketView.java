package com.muthukumarasamy.busticket.viewticket;

import java.util.List;

import com.muthukumarasamy.busticket.colors.Color;
import com.muthukumarasamy.busticket.dto.Ticket;
import com.muthukumarasamy.busticket.dto.User;
import com.muthukumarasamy.busticket.repository.TicketRepo;

public class TicketView extends Color {

	private TicketViewModel ticketviewmodel;

	public TicketView() {
		ticketviewmodel = new TicketViewModel();
	}

	public void viewticket(User data) {
		List<Ticket> ticketlist = ticketviewmodel.getTicket(data.getUsername());

		if(ticketlist.isEmpty())
			System.out.println(RED+"Currently, no tickets are available."+RESET);
		else
			view(ticketlist);
	}

	public void viewHistory(User data) {

		List<Ticket> ticketlist = ticketviewmodel.getHistory(data.getUsername());

		
		if(ticketlist.isEmpty())
			System.out.println(RED+"There is no history of tickets"+RESET);
		else
			view(ticketlist);
	}

	private void view(List<Ticket> ticketlist) {
		for (Ticket userticket : ticketlist) {

			System.out.println("-----------------------------------------");
			System.out.println("_________________________________________");
			System.out.println(
					(CYAN + "| UserName         : " + RESET) + (BRIGHT_WHITE + userticket.getUserName() + RESET));
			System.out.println(
					(CYAN + "| BusName          : " + RESET) + (BRIGHT_WHITE + userticket.getBusName() + RESET));
			System.out
					.println((CYAN + "| Date             : " + RESET) + (BRIGHT_WHITE + userticket.getDate() + RESET));
			System.out.println(
					(CYAN + "| Arrival          : " + RESET) + (BRIGHT_WHITE + userticket.getArrival() + RESET));
			System.out.println(
					(CYAN + "| Departure        : " + RESET) + (BRIGHT_WHITE + userticket.getDeparture() + RESET));
			System.out
					.println((CYAN + "| Price            : " + RESET) + (BRIGHT_WHITE + userticket.getPrice() + RESET));
			System.out
					.println((CYAN + "| Booked seats     : " + RESET) + (BRIGHT_WHITE + userticket.getSeats() + RESET));

			System.out.println((CYAN + "| Status           : " + RESET) + (printstatus(userticket.getStatus())));

			System.out.println("-----------------------------------------");
			System.out.println("_________________________________________");

		}

	}

	public String printstatus(String status) {
		
		if (status.equals("Completed"))
			return BRIGHT_WHITE + "Completed" + RESET;
		
		else if (status.equals("OnProcess"))
			return BRIGHT_GREEN + "OnProcess" + RESET;
		
		else
			return BRIGHT_RED + "Cancelled" + RESET;

	}

}

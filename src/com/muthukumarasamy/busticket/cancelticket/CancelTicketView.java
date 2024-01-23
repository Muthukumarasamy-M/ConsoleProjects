package com.muthukumarasamy.busticket.cancelticket;

import java.util.List;
import java.util.Scanner;

import com.muthukumarasamy.busticket.colors.Color;
import com.muthukumarasamy.busticket.dto.Ticket;
import com.muthukumarasamy.busticket.dto.User;

public class CancelTicketView extends Color {

	private CancelTicketViewModel cancelticketviewmodel;

	public CancelTicketView() {
		cancelticketviewmodel = new CancelTicketViewModel();
	}

	public void cancelTicket(User data) {
		Scanner mc = new Scanner(System.in);
		int index = 0;
		List<Ticket> ticketlist = cancelticketviewmodel.getTicket(data.getUsername());

		if (ticketlist.isEmpty())
			System.out.println(RED + "Currently, no tickets are available." + RESET);
		else {
			for (Ticket userticket : ticketlist) {

				System.out.println("-----------------------------------------");
				System.out.println("TICKET -> " + (++index));
				System.out.println("_________________________________________");
				System.out.println(
						(CYAN + "| UserName         : " + RESET) + (BRIGHT_WHITE + userticket.getUserName() + RESET));
				System.out.println(
						(CYAN + "| BusName          : " + RESET) + (BRIGHT_WHITE + userticket.getBusName() + RESET));
				System.out.println(
						(CYAN + "| Date             : " + RESET) + (BRIGHT_WHITE + userticket.getDate() + RESET));
				System.out.println(
						(CYAN + "| Arrival          : " + RESET) + (BRIGHT_WHITE + userticket.getArrival() + RESET));
				System.out.println(
						(CYAN + "| Departure        : " + RESET) + (BRIGHT_WHITE + userticket.getDeparture() + RESET));
				System.out.println(
						(CYAN + "| Price            : " + RESET) + (BRIGHT_WHITE + userticket.getPrice() + RESET));
				System.out.println(
						(CYAN + "| Booked seats     : " + RESET) + (BRIGHT_WHITE + userticket.getSeats() + RESET));
			}

			System.out.println("_________________________________________");
			System.out.print("Enter the Ticket number cancel -> ");
			int select = mc.nextInt();
			System.out.println();
			cancelticketviewmodel.cancelticket(ticketlist.get(select - 1));
		}

	}
}

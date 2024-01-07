package com.muthukumarasamy.busticketbooking.baseview;

import java.util.Scanner;

import com.muthukumarasamy.busticketbooking.bookticket.BookTicketView;
import com.muthukumarasamy.busticketbooking.cancelticket.CancelTicketView;
import com.muthukumarasamy.busticketbooking.colors.Color;
import com.muthukumarasamy.busticketbooking.viewbooking.BookingView;

public class HomeView extends Color {

	public static void start() {

		int select;
		HomeView home = new HomeView();
		Scanner mc = new Scanner(System.in);
		do {
			home.print();
			select = mc.nextInt();
			mc.nextLine();
			switch (select) {
			case 1:
				BookTicketView bookticketview = new BookTicketView();
				bookticketview.bookTicket();
				break;
			case 2:
				BookingView bookingview = new BookingView();
				bookingview.viewBooking();
				break;
			case 3:
				CancelTicketView cancelticketview = new CancelTicketView();
				cancelticketview.cancelTicket();
			}
			if (select != 4) {
				home.Continue();
				mc.nextLine();
			}

		} while (select != 4);
		home.Exit();

	}

	public void Continue() {
		System.out.println(RED + "------------------------------" + RESET);
		System.out.println("press enter to continue");
	}

	public void print() {
		System.out.println(BLUE + "          ~~BUS TICKET BOOKING~~       " + RESET);
		System.out.println("\t" + BLUE + "+---+-----+----+-----+----+" + RESET);
		System.out.printf("\t| %-2s| %-30s |\n", WHITE + "1" + RESET, BRIGHT_WHITE + "Book Ticket" + RESET);
		System.out.printf("\t| %-2s| %-30s |\n", WHITE + "2" + RESET, BRIGHT_WHITE + "View Bookings" + RESET);
		System.out.printf("\t| %-2s| %-30s |\n", WHITE + "3" + RESET, BRIGHT_WHITE + "Cancel Ticket" + RESET);
		System.out.printf("\t| %-2s| %-31s |\n", WHITE + "4" + RESET, BRIGHT_WHITE + "Exit " + RESET);
		System.out.println("\t" + BLUE + "+---+-----+----+-----+----+" + RESET);
		System.out.print("Enter the option: ");
	}

	public void Exit() {
		System.out.println("\tExited !!!");
	}
}

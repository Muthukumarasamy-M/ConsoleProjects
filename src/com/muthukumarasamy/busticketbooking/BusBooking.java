package com.muthukumarasamy.busticketbooking;

import java.util.Scanner;

import com.muthukumarasamy.busticketbooking.bookticket.BookTicketView;
import com.muthukumarasamy.busticketbooking.cancelticket.CancelTicketView;
import com.muthukumarasamy.busticketbooking.viewbooking.BookingView;

public class BusBooking {

	public static void main(String[] args) {
		BusBooking busbooking = new BusBooking();
		busbooking.init();

	}

	private void init() {

		int select;
		Scanner mc = new Scanner(System.in);
		do {
			print();
			System.out.print("Enter the option: ");
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
				Continue();
				mc.nextLine();
			}

		} while (select != 4);
		System.out.println("\tExited !!!");

	}

	private void Continue() {
		System.out.println("------------------------------");
		System.out.println("press enter to continue");
	}

	private void print() {
		System.out.println("          ~~BUS TICKET BOOKING~~       ");
		System.out.println("\t+---+-----+----+-----+----+");
		System.out.printf("\t| %-2s| %-19s |\n", "1", "Book Ticket");
		System.out.printf("\t| %-2s| %-19s |\n", "2", "View Bookings");
		System.out.printf("\t| %-2s| %-19s |\n", "3", "Cancel Ticket");
		System.out.printf("\t| %-2s| %-19s |\n", "4", "Exit");
		System.out.println("\t+---+-----+----+-----+----+");

	}
}
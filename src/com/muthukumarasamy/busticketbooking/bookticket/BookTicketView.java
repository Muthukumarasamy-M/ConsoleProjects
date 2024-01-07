package com.muthukumarasamy.busticketbooking.bookticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.muthukumarasamy.busticketbooking.dto.BUS;
import com.muthukumarasamy.busticketbooking.dto.Booking;
import com.muthukumarasamy.busticketbooking.repository.Repository;

public class BookTicketView {

	private BookTicketViewModel bookticketviewmodel;
	private static List<BUS> Bus;
	private static BUS bus;
	static List<List<String>> seats = new ArrayList<>();

	public BookTicketView() {
		bookticketviewmodel = new BookTicketViewModel();

	}

	public void bookTicket() {
		BookTicketView bookticketview = new BookTicketView();
		Bus = bookticketviewmodel.getBus();
		Scanner mc = new Scanner(System.in);
		System.out.print("Name : ");
		String name = mc.nextLine();
		System.out.print("Age : ");
		String age = mc.nextLine();
		System.out.print("From : ");
		String start = mc.nextLine();
		System.out.print("To   : ");
		String end = mc.nextLine();
		bookticketview.availableBuses();
		System.out.print("Select the option : ");
		int num = mc.nextInt();
		bookticketview.seating(num);
		System.out.print("Enter the no of seats to book: ");
		int no = mc.nextInt();
		mc.nextLine();
		String booked = "";
		if (no == 1)
			booked = mc.next();
		else {
			for (int i = 0; i < no; i++) {
				String cur = mc.nextLine();
				booked += cur + ",";
			}
		}
		bookticketviewmodel.addBooking(name, age, bus, booked);
		if (bookticketviewmodel.removeSeats(booked, num, bus, seats))
			System.out.println("Booked successfully");
		else {

			System.out.println("No such seats are available");
		}
	}

	public void availableBuses() {
		List<String> buses = new ArrayList<>();
		System.out.println("Available Buses:");
		System.out.println("\t+-----+------------------+--------+----------------+");

		System.out.printf("\t| %-3s | %-16s | %-6s | %-12s |%n", "ID", "Bus Name", "Price", "Departure Time");

		for (BUS bus : Bus) {
			System.out.println("\t+-----+------------------+--------+----------------+");

			System.out.printf("\t| %-3s | %-16s | %-6s | %-14s |%n", Bus.indexOf(bus) + 1, bus.getBusName(),
					bus.getPrice(), bus.getDepartureTime());
			buses.add(bus.getBusName());
		}

		System.out.println("\t+-----+------------------+--------+----------------+");
	}

	public void seating(int num) {
		bus = Bus.get(num - 1);
		seats = bus.getSeating();
		System.out.println("+-----+--------------+--------+--------------+");
		System.out.println("BUS Arrangement: ");
		System.out.println("\t--^^------------^^---");
		System.out.printf("\t}%12s%5s%3s", "|", "(Y)", "|");
		System.out.print("\n\t---------------------\n");

		int lastRowIndex = seats.size() - 1;

		for (int i = 0; i <= lastRowIndex; i++) {
			System.out.print("\t| ");

			List<String> row = seats.get(i);

			if (i == lastRowIndex) {
				for (String seat : row) {
					if (row.indexOf(seat) == row.size() - 1)
						System.out.print(seat);
					else
						System.out.printf("%-4s", seat);
				}
			} else {
				int halfSize = row.size() / 2;

				for (int j = 0; j < row.size(); j++) {
					System.out.printf("%-3s", row.get(j));

					if (j == halfSize - 1) {
						System.out.print("|   | ");
					}
				}
			}

			System.out.println("|");
		}
		System.out.println("\t+-------------------+");

	}

}

package com.muthukumarasamy.busticketbooking.viewbooking;

import java.util.List;

import com.muthukumarasamy.busticketbooking.dto.Booking;

public class BookingView {

	public BookingViewModel bookingviewmodel;

	public BookingView() {
		bookingviewmodel = new BookingViewModel();
	}

	public void viewBooking() {
		System.out.println("-------------------------------------");
		List<Booking> bookings = bookingviewmodel.getBooking();

		if (bookings.isEmpty()) {
			System.out.println("No bookings available.");
		} else {
			System.out.println("Booking Details:");
			System.out.println("\t+------+--------------+-----+-----------------+------------+");
			System.out.printf("\t| %-4s | %-12s | %-3s | %-15s | %-10s |%n", "ID", "User Name", "Age", "Bus Name",
					"Seats");
			System.out.println("\t+------+--------------+-----+-----------------+------------+");

			for (Booking booking : bookings) {
				System.out.printf("\t| %-4s | %-12s | %-3s | %-15s | %-10s |%n",
						bookings.indexOf(booking) + 1, booking.getUserName(), booking.getAge(), booking.getBus(),
						booking.getSeats());
			}

			System.out.println("\t+------+--------------+-----+-----------------+------------+");
		}
	}

}

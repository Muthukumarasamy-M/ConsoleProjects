package com.muthukumarasamy.busticketbooking.cancelticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.muthukumarasamy.busticketbooking.dto.BUS;
import com.muthukumarasamy.busticketbooking.dto.Booking;
import com.muthukumarasamy.busticketbooking.repository.Repository;

class CancelTicketViewModel {

	private static List<Booking> booking = Repository.getInstance().getBooking();
	private static List<BUS> data = Repository.getInstance().getBus();
	private static Booking books;

	private static List<List<String>> seats = new ArrayList();

	public int cancelticket(String name, String age) {

		int index = -1;
		for (Booking book : booking) {
			if (book.getUserName().equals(name) && book.getAge().equals(age)) {
				books = book;
				index = booking.indexOf(book);
			}
		}
		if (index == -1)
			System.out.println("NO such bookings");
		else
			Repository.getInstance().removeBooking(index);
		return index;
	}

	public List<List<String>> replaceTicket(List<List<String>> seats) {
		List<String> selected = Arrays.asList(books.getSeats().split(","));
		for (String string : selected) {
			int row = string.charAt(0) - 'a';
			int col = string.charAt(1) - '1';

			List<String> inner = seats.get(row);
			inner.set(col, string);
			seats.set(row, inner);
		}
		System.out.println(selected + " seats have been restocked");

		return seats;

	}

	public void getSeats() {
		for (BUS bus : data) {
			if (bus.getBusName().equals(books.getBus())) {
				bus.setSeating(replaceTicket(bus.getSeating()));
			}

		}

		Repository.getInstance().replaceBus(data);
	}

}

package com.muthukumarasamy.busticketbooking.bookticket;

import java.util.Arrays;
import java.util.List;

import com.muthukumarasamy.busticketbooking.dto.BUS;
import com.muthukumarasamy.busticketbooking.dto.Booking;
import com.muthukumarasamy.busticketbooking.repository.Repository;

public class BookTicketViewModel {

	public boolean removeSeats(String booked, int num, BUS bus, List<List<String>> seats) {
		List<String> bookedSeat = Arrays.asList(booked.split(","));
		boolean found = false;
		for (List<String> row : seats) {
			for (int i = 0; i < row.size(); i++) {
				if (bookedSeat.contains(row.get(i))) {
					row.set(i, "0");
					found = true;
				}
			}
		}
		if (found) {
			bus.setSeating(seats);
			Repository.getInstance().savebustoJson();
			return true;

		} else
			return false;
	}

	public void addBooking(String name, String age, BUS bus, String booked) {
		Booking book = new Booking(name, age, bus.getBusName(), booked);
		Repository.getInstance().addBooking(book);
	}

	public List<BUS> getBus() {
		return Repository.getInstance().getBus();

	}

}

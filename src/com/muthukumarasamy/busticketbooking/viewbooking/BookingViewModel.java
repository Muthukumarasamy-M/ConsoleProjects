package com.muthukumarasamy.busticketbooking.viewbooking;

import java.util.List;

import com.muthukumarasamy.busticketbooking.dto.Booking;
import com.muthukumarasamy.busticketbooking.repository.Repository;

public class BookingViewModel {


	public List<Booking> getBooking() {
		return Repository.getInstance().getBooking();
	}

}

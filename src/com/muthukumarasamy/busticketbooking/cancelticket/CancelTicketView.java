package com.muthukumarasamy.busticketbooking.cancelticket;

import java.util.Scanner;

public class CancelTicketView {

	private CancelTicketViewModel cancelticketviewmodel;

	public CancelTicketView() {
		cancelticketviewmodel = new CancelTicketViewModel();
	}

	public void cancelTicket() {
		Scanner mc = new Scanner(System.in);
		System.out.print("\nEnter the userName: ");
		String name = mc.next();
		System.out.print("Enter the Age : ");
		String age = mc.next();
		int num = cancelticketviewmodel.cancelticket(name, age);
		if (num != -1)
			cancelticketviewmodel.getSeats();

	}

}

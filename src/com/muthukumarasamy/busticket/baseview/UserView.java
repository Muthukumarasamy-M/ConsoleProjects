package com.muthukumarasamy.busticket.baseview;

import java.util.Scanner;

import com.muthukumarasamy.busticket.baseview.HomeView;
import com.muthukumarasamy.busticket.bookticket.BookticketView;
import com.muthukumarasamy.busticket.cancelticket.CancelTicketView;
import com.muthukumarasamy.busticket.colors.Color;
import com.muthukumarasamy.busticket.dto.User;
import com.muthukumarasamy.busticket.viewticket.TicketView;

public class UserView extends Color {

	public void start(User data) {

		Scanner mc = new Scanner(System.in);
		HomeView homeview = new HomeView();
		int select = 0;
		do {
			homeview.innerScreen();
			select = mc.nextInt();
			mc.nextLine();
			switch (select) {

			case 1:
				BookticketView  busticketview = new BookticketView();
				busticketview.bookticket(data);
				break;
			case 2:
				TicketView ticketview = new TicketView();
				ticketview.viewticket(data);
				break;
			case 3:
				CancelTicketView cancelticketview = new CancelTicketView();
				cancelticketview.cancelTicket(data);
				break;
			case 4:
				TicketView viewhistory = new TicketView();
				viewhistory.viewHistory(data);
				break;
			}
			if (select != 5) {
				Continue();
				mc.nextLine();
			}

		} while (select != 5);
		Exit();

	}

	private void Exit() {
		System.out.println(BRIGHT_YELLOW+"\tExited !!! "+RESET);
	}

	public void Continue() {
		System.out.println(BLUE + "----------------------------------" + RESET);
		System.out.println(CYAN+"press enter to continue"+RESET);
	}
}

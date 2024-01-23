package com.muthukumarasamy.busticket.bookticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.muthukumarasamy.busticket.colors.Color;
import com.muthukumarasamy.busticket.dto.Bus;
import com.muthukumarasamy.busticket.dto.Ticket;
import com.muthukumarasamy.busticket.dto.User;

public class BookticketView extends Color {

	private BookticktetViewModel bookticketviewmodel;
	Scanner mc = new Scanner(System.in);

	public BookticketView() {
		bookticketviewmodel = new BookticktetViewModel();
	}

	public void bookticket(User data) {

		String date[] = getdates();
		int dateindex = mc.nextInt();

		List<String[]> standlist = bookticketviewmodel.getbusstands();
		int index = 1;

		System.out.println("\t"+BLUE+"+--------------------------+"+RESET);
		System.out.printf("\t| %-25s|\n","   Available Bus stops  ");
		System.out.println("\t"+BLUE+"+--------------------------+"+RESET);
		String last[]= standlist.get(standlist.size()-1);
		for (String[] record : standlist) {

			int len = last[0].length()-record[0].length()+1;
			System.out.printf("\t| %-6s | %-32s \n",(BRIGHT_WHITE+index+RESET),(BRIGHT_WHITE+record[0]+RESET));
			index++;
		}
		System.out.println(printblue("+---------------------------------------------------------------+"));

		System.out.print(printcyan("Select  your Start Point : "));
		int startindex = mc.nextInt();
		System.out.print(printcyan("\nSelect  your End Point : "));
		int endindex = mc.nextInt();
		System.out.print(printblue("\n+------------------------------------------------------------------+\n"));

		String[] start = standlist.get(startindex - 1);
		String[] end = standlist.get(endindex - 1);
		String price = getPrice(standlist, startindex - 1, endindex - 1);
		System.out.println(printcyan("Your price is ") + price+".00");
		Bus userbus = bookticketviewmodel.getBus(dateindex - 1);

		String seats = displayseating(userbus.getSeating());
		bookticketviewmodel.removeSeats(seats, userbus);
		Ticket ticket = new Ticket(data.getUsername(), date[dateindex - 1], start[0], end[0], price,
				userbus.getBusName(), seats,"OnProcess");

		bookticketviewmodel.addtoTicketlist(ticket);
		System.out.println(CYAN + "Ticket has been added " + RESET);
	}

	private String printcyan(String string) {
		return CYAN + string + RESET;
	}

	private String printblue(String value) {

		return (BLUE + value + RESET);

	}

	private String printbw(String value) {
		return (BRIGHT_WHITE + value + RESET);
	}

	private String displayseating(List<List<String>> seating) {

		System.out.print(printblue("\n+------------------------------------------------------------------+\n"));
		System.out.println(printbw("\tBUS Arrangement: "));
		System.out.println("\t--^^------------^^----");
		System.out.printf("\t}%12s%5s%5s", "|", "(Y)", "|");
		System.out.print("\n\t----------------------\n");

		int lastRowIndex = seating.size() - 1;

		for (int i = 0; i <= lastRowIndex; i++) {
			System.out.print("\t| ");

			List<String> row = seating.get(i);

			if (i == lastRowIndex) {
				for (String seat : row) {
					if (row.indexOf(seat) == row.size() - 1)
						System.out.print(BRIGHT_YELLOW + seat + RESET);
					else
						System.out.printf(BRIGHT_YELLOW + "%-4s" + RESET, seat);
				}
			} else {
				int halfSize = row.size() / 2;

				for (int j = 0; j < row.size(); j++) {
					System.out.printf(BRIGHT_YELLOW + "%-3s" + RESET, row.get(j));

					if (j == halfSize - 1) {
						System.out.print("|   | ");
					}
				}
			}

			System.out.println("|");
		}
		System.out.println("\t+--------------------+");
		System.out.print(printcyan("Enter the no of seats to book: "));
		int no = mc.nextInt();
		mc.nextLine();
		String booked = "";
		System.out.println(printcyan("seats are :"));
		if (no == 1)
			booked = mc.next();
		else {
			for (int i = 0; i < no; i++) {
				String cur = mc.nextLine();
				booked += cur + ",";
			}
		}
		return booked;
	}

	private String getPrice(List<String[]> standlist, int start, int end) {

		int price = 0;

		while (start < end) {
			String[] str = standlist.get(start);
			price += Integer.valueOf(str[1]);
			start++;
		}
		return String.valueOf(price * 10);
	}

	private String[] getdates() {
		System.out.println("\n\t"+BLUE + "+----------------------+" + RESET);
		System.out.println("\t"+CYAN + "    Available Dates" + RESET);
		System.out.println("\t"+BLUE + "+----------------------+" + RESET);

		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String[] dates = { today.format(formatter), today.plusDays(1).format(formatter),
				today.plusDays(2).format(formatter) };

		for (int i = 1; i <= 3; i++)
			System.out.println("\t"+BLUE + "| " + RESET + i + "  | " + dates[i - 1] + " " + BLUE + "     |" + RESET);

		System.out.println("\t"+BLUE + "+----------------------+" + RESET);
		System.out.print(CYAN + "Select the date: " + RESET);

		return dates;
	}
}

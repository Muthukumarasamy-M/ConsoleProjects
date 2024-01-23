package com.muthukumarasamy.busticket.baseview;

import java.util.Scanner;

import com.muthukumarasamy.busticket.colors.Color;
import com.muthukumarasamy.busticket.dto.User;

public class HomeView extends Color {

	private HomeViewModel homeviewmodel;

	public HomeView() {
		this.homeviewmodel = new HomeViewModel();

	}

	Scanner mc = new Scanner(System.in);

	public void Start() {
		int select = 0;
		do {
			homeScreen();
			select = mc.nextInt();
			mc.nextLine();
			User data = getValues();

			switch (select) {
			case 1:
				signup(data);
			case 2:
				signin(data);
			case 3:
				break;}
			if (select != 3) {
				Continue();
				mc.nextLine();
			}

		} while (select != 4);
		Exit();

	}

	private void Exit() {
		System.out.println(BRIGHT_YELLOW+"\tExited !!! "+RESET);
	}

	public void Continue() {
		System.out.println(RED + "------------------------------" + RESET);
		System.out.println(CYAN+"press enter to continue"+RESET);
	}
	private void signin(User data) {

		if (homeviewmodel.ispresent(data)) {
			UserView view = new UserView();
			welcome(data.getUsername());
			view.start(data);
		} else {
			System.out.println("\n" + BRIGHT_RED
					+ "Username and passoword not exists .\n  Please enter correct values \n" + RESET);
			getValues();
		}

	}

	private void welcome(String username) {
		System.out.println(BLUE + "+-------------------------------+" + RESET);
		System.out.println("\t" + CYAN + " Welcome  " + RESET + username.toUpperCase());
		System.out.println(BLUE + "+-------------------------------+\n\n" + RESET);

	}

	private void signup(User data) {

		if (homeviewmodel.ispresent(data)) {
			System.out.println("\n" + BRIGHT_RED + "User already exits" + RESET);
			User user = getValues();
			signup(user);
		} else {
			homeviewmodel.adduser(data);
			welcome(data.getUsername());
			UserView view = new UserView();
			view.start(data);

		}

	}

	public User getValues() {

		System.out.println(BLUE + "+-------------------------------+" + RESET);

		System.out.print("" + CYAN + "Enter the username --> " + RESET);
		String name = mc.nextLine();
		if (!homeviewmodel.validateName(name)) {
			usernameRules();
			getValues();
		}
		System.out.print("\n" + CYAN + "Enter the password --> " + RESET);

		String password = mc.nextLine();

		System.out.println(BLUE + "+-------------------------------+" + RESET);
		if (!homeviewmodel.validatePassword(password)) {
			passwordRules();
			getValues();
		}

		return new User(name, password);
	}

	private void passwordRules() {
		System.out.println(RED + "The password is incorrect ");
		System.out.println(
				"Rules : length should between 8-16 , \nshould contain atleast one uppercase, one lowercase, one special character , one digit \n"
						+ RESET);

	}

	private void usernameRules() {

		System.out.println(RED + "The username is invalid ");
		System.out.println("Rules: length should between 8-20 ,only letters,digits and underscore  \n" + RESET);

	}

	private void homeScreen() {

		System.out.println(BLUE + "=====================================================" + RESET);
		System.out.println(BRIGHT_YELLOW + "          BUS TICKET BOOKING      " + RESET);
		System.out.println(BLUE + "=====================================================" + RESET);
		System.out.println("\t" + BLUE + "+---+------------------+" + RESET);
		System.out.printf("\t| %-3s |   %-25s|\n", BLUE + "1" + RESET, BRIGHT_WHITE + "Sign up" + RESET);
		System.out.printf("\t| %-3s |   %-25s|\n", BLUE + "2" + RESET, BRIGHT_WHITE + "Sign in" + RESET);
		System.out.printf("\t| %-3s |   %-25s|\n", BLUE + "3" + RESET, BRIGHT_WHITE + "Exit " + RESET);
		System.out.println("\t" + BLUE + "+---+------------------+" + RESET);
		System.out.print(CYAN + "Enter the operation -> " + RESET);
	}

	public void innerScreen() {
		System.out.println("\t" + BLUE + "+---+------------------+" + RESET);
		System.out.printf("\t| %-2s | %-27s|\n", BLUE + "1" + RESET, BRIGHT_WHITE + "Book ticket" + RESET);
		System.out.printf("\t| %-2s | %-27s|\n", BLUE + "2" + RESET, BRIGHT_WHITE + "View Ticket" + RESET);
		System.out.printf("\t| %-2s | %-27s|\n", BLUE + "3" + RESET, BRIGHT_WHITE + "CancelTicket" + RESET);
		System.out.printf("\t| %-2s | %-27s|\n", BLUE + "4" + RESET, BRIGHT_WHITE + "View History" + RESET);
		System.out.printf("\t| %-2s | %-27s|\n", BLUE + "5" + RESET, BRIGHT_WHITE + "Log out" + RESET);
		System.out.println("\t" + BLUE + "+---+------------------+" + RESET);

		System.out.print(CYAN + "Enter the operation -> " + RESET);
	}

}

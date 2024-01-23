package com.muthukumarasamy.rolehierarchy.display;

import java.util.Scanner;

public class DisplayView {

	private DisplayViewModel displayviewmodel;
	Scanner mc = new Scanner(System.in);

	public DisplayView() {
		displayviewmodel = new DisplayViewModel();
		displayviewmodel.findhdata();
	}

	public void displayRole() {

		System.out.println(displayviewmodel.displayRole());
	}

	public void displayUser() {
		
		System.out.println(displayviewmodel.displayUser());
	}

	public void displayUserandSub() {

		System.out.println(displayviewmodel.displayUserandSub());

	}

	public void countUsersBetween() {

		System.out.print("Enter the name ");
		String name = mc.nextLine();
		System.out.println("From the top : " + displayviewmodel.countUsersBetween(name));

	}

	public void countHieght() {
		System.out.println("height : " + displayviewmodel.countUserHeight());
	}

	public void commonBoss() {
		System.out.print("Enter the user 1: ");
		String user1 = mc.nextLine();
		System.out.print("Enter the user 2: ");
		String user2 = mc.nextLine();
		System.out.println("Common Boss :" +displayviewmodel.commonBoss(user1,user2));
		

	}
}

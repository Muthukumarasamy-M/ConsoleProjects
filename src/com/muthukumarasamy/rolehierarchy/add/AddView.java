package com.muthukumarasamy.rolehierarchy.add;

import java.util.Scanner;

import com.muthukumarasamy.rolehierarchy.dto.Data;

public class AddView {

	private AddViewModel addviewmodel;

	Scanner mc = new Scanner(System.in);

	public AddView() {
		addviewmodel = new AddViewModel();
	}

	public void AddSubRole() {

		System.out.print("Enter the Sub Role : ");
		String role = mc.nextLine();
		System.out.print("Enter the Reporting to  : ");
		String r = mc.nextLine();
		Data data  =new Data();
		addviewmodel.addSubrole(new Data(role,r,"-"));
	}

	public void AddUser() {

		System.out.print("Enter the UserName : ");
		String user = mc.nextLine();
		System.out.print("Enter the role : ");
		String role = mc.nextLine();
		addviewmodel.addUser(user, role);

	}
}

package com.muthukumarasamy.rolehierarchy.view;

import java.util.Scanner;

import com.muthukumarasamy.rolehierarchy.dto.Data;

public class BaseView {

	private BaseViewModel baseviewmodel;
	static Scanner mc = new Scanner(System.in);

	public BaseView() {
		baseviewmodel = new BaseViewModel();
	}

	public void methodView() {

		System.out.println("+------------------------------");
		System.out.println("|operations:                  |");
		System.out.println("|  1. AddSubRole              |");
		System.out.println("|  2. DisplayRoles            |");
		System.out.println("|  3. DeleteRole              |");
		System.out.println("|  4. Add User                |");
		System.out.println("|  5. Display User            |");
		System.out.println("|  6. Display User and subuser|");
		System.out.println("|  7. DeleteUser              |");
		System.out.println("|  8. CountUserBetween        |");
		System.out.println("|  9. Total height            |");
		System.out.println("|  10.Common Boss             |");
		System.out.println("|  11.Exit                    |");
		System.out.println("+------------------------------");
		System.out.print("Enter the operation : ");
	}

	public void Continue() {
		System.out.println("------------------------------");
		System.out.println("press enter to continue");
	}
	public void checkRoot() {

		if (baseviewmodel.checkRoot() == -1) {
			System.out.print("Enter the Root role : ");
			String s = mc.next();

			baseviewmodel.addFirst(new Data(s, null, null));
		}

	}

	public void Exit() {
		System.out.println("EXITED !!! ");
	}
}

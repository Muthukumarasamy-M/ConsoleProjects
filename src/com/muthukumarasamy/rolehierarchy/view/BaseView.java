package com.muthukumarasamy.rolehierarchy.view;

import java.util.Scanner;

import com.muthukumarasamy.rolehierarchy.add.AddView;
import com.muthukumarasamy.rolehierarchy.delete.DeleteView;
import com.muthukumarasamy.rolehierarchy.display.DisplayView;
import com.muthukumarasamy.rolehierarchy.dto.Data;

public class BaseView {

	private BaseViewModel baseviewmodel;
	static Scanner mc = new Scanner(System.in);

	public BaseView() {
		baseviewmodel = new BaseViewModel();
	}

	public void start() {
		Scanner mc = new Scanner(System.in);
		BaseView baseview = new BaseView();
		AddView add = new AddView();
		DeleteView delete = new DeleteView();
		baseview.checkRoot();

		int select = 0;
		do {
			methodView();
			select = mc.nextInt();
			mc.nextLine();
			switch (select) {
			case 1:
				add.AddSubRole();
				break;
			case 2:
				DisplayView display = new DisplayView();
				display.displayRole();
				break;
			case 3:
				delete.deleterole();
				break;
			case 4:
				add.AddUser();
				break;
			case 5:
				DisplayView display1 = new DisplayView();
				display1.displayUser();
				break;
			case 6:
				DisplayView display2 = new DisplayView();
				display2.displayUserandSub();
				break;
			case 7:
				delete.deleteUser();
				break;
			case 8:
				DisplayView display3 = new DisplayView();
				display3.countUsersBetween();
				break;
			case 9:
				DisplayView display4 = new DisplayView();
				display4.countHieght();
				break;
			case 10:
				DisplayView display5 = new DisplayView();
				display5.commonBoss();
				break;
			}
			if (select != 11) {
				Continue();
				mc.nextLine();
			}
		} while (select != 11);
		Exit();
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
		System.out.println("------------------------------");
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

package com.muthukumarasamy.rolehierarchy;

import java.util.Scanner;

import com.muthukumarasamy.rolehierarchy.add.AddView;
import com.muthukumarasamy.rolehierarchy.delete.DeleteView;
import com.muthukumarasamy.rolehierarchy.display.DisplayView;
import com.muthukumarasamy.rolehierarchy.view.BaseView;

public class RoleHeirarchy {

	public static void main(String[] args) {

		RoleHeirarchy r = new RoleHeirarchy();
		r.init();

	}

	private void init() {
		Scanner mc = new Scanner(System.in);
		BaseView baseview = new BaseView();
		AddView add = new AddView();
		DeleteView delete = new DeleteView();
		baseview.checkRoot();

		int select = 0;
		do {
			baseview.methodView();
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
				baseview.Continue();
				mc.nextLine();
			}
		} while (select != 11);
		baseview.Exit();
	}

}

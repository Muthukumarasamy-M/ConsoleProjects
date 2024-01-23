package com.muthukumarasamy.rolehierarchy.delete;

import java.util.Scanner;

public class DeleteView {

	private DeleteViewModel deleteroleviewmodel;
	Scanner mc = new Scanner(System.in);

	public DeleteView() {
		deleteroleviewmodel = new DeleteViewModel();
	}

	public void deleterole() {
		System.out.print("Enter the Role to be deleted  : ");
		String role = mc.nextLine();
		System.out.print("Enter the Role to be Transfered : ");
		String tranf = mc.nextLine();
		deleteroleviewmodel.deleterole(role, tranf.trim());
	}

	public void deleteUser() {
		System.out.print("Enter the Role to be deleted  : ");
		String role = mc.nextLine();
		System.out.print("Enter the Role to be Transfered : ");
		String tranf = mc.nextLine();
		deleteroleviewmodel.deleteuser(role, tranf.trim());
		
		
	}
}

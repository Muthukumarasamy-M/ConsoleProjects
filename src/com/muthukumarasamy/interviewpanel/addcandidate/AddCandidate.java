package com.muthukumarasamy.interviewpanel.addcandidate;

import java.util.Scanner;

import com.muthukumarasamy.interviewpanel.dto.Candidate;

public class AddCandidate {

	private AddCandidateViewModel addCandidateViewmodel;

	public AddCandidate() {
		addCandidateViewmodel = new AddCandidateViewModel();
	}

	public void getCandidateInfo() {

		Candidate candidate = new Candidate();

		Scanner mc = new Scanner(System.in);
		System.out.print("Enter the Name : ");
		candidate.setName(mc.nextLine());
		System.out.print("Enter the Qualification : ");
		candidate.setQualification(mc.nextLine());
		System.out.print("Enter the DOB (dd-mm-yyyy) : ");
		candidate.setDob(mc.nextLine());
		System.out.print("Enter the Year of Passout : ");
		candidate.setYear(mc.nextInt());

		addCandidateViewmodel.validate(candidate);
	}

}
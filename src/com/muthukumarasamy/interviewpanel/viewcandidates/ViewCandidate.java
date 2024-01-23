package com.muthukumarasamy.interviewpanel.viewcandidates;

import com.muthukumarasamy.interviewpanel.dto.Candidate;

public class ViewCandidate {

	private ViewCandidateViewmodel viewCandidateViewmodel;

	public ViewCandidate() {
		viewCandidateViewmodel = new ViewCandidateViewmodel();
	}

	public void viewTotalList() {

		for (Candidate candidate : viewCandidateViewmodel.getTotalList()) {
			System.out.println(candidate.getName() + " " + candidate.getQualification() + " " + candidate.getYear());
		}
	}
	
	public void viewGetRemainingList() {
		for (Candidate candidate : viewCandidateViewmodel.getRemainingList()) {
			System.out.println(candidate.getName() + " " + candidate.getQualification() + " " + candidate.getYear());
		}

	}

	public void getCurrentStatus() {
		Candidate candidate = viewCandidateViewmodel.getCurrentStatus();
		System.out.println(candidate.getName() + " " + candidate.getQualification() + " " + candidate.getYear());

	}

}

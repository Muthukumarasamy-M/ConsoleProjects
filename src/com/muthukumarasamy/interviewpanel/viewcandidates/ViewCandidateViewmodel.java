package com.muthukumarasamy.interviewpanel.viewcandidates;

import java.util.ArrayList;
import java.util.Queue;

import com.muthukumarasamy.interviewpanel.dto.Candidate;
import com.muthukumarasamy.interviewpanel.repository.Repository;

class ViewCandidateViewmodel {

	public ArrayList<Candidate> getTotalList() {
		return Repository.getInstance().getTotalList();

	}

	public Queue<Candidate> getRemainingList() {
		return Repository.getInstance().getRemainingList();
	}

	public Candidate getCurrentStatus() {

		return Repository.getInstance().getCurrentStatus();

	}

}

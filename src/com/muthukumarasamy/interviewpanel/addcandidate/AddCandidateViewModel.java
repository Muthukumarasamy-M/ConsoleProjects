package com.muthukumarasamy.interviewpanel.addcandidate;

import com.muthukumarasamy.interviewpanel.dto.Candidate;
import com.muthukumarasamy.interviewpanel.repository.Repository;

class AddCandidateViewModel {
	
	public void validate(Candidate candidate)
	{
		Repository.getInstance().InsertList(candidate);
	}
	
}

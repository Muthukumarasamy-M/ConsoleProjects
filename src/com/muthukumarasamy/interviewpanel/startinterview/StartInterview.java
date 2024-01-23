package com.muthukumarasamy.interviewpanel.startinterview;

import com.muthukumarasamy.interviewpanel.dto.Candidate;

public class StartInterview implements Runnable {

	private StartInterviewViemodel startinterviewviewmodel;
	private Candidate Candidate;

	public StartInterview() {
		startinterviewviewmodel = new StartInterviewViemodel();
	}

	public StartInterview(Candidate candidate) {
		this.Candidate = candidate;
	}

	public void startProcess() {
		startinterviewviewmodel.startInterviewIfNotRunning();
	}

	public void run() {
	
        System.out.println("Interview completed for: " + Candidate.getName());
    }
}

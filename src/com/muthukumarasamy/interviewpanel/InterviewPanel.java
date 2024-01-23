package com.muthukumarasamy.interviewpanel;

import java.util.Scanner;

import com.muthukumarasamy.interviewpanel.addcandidate.AddCandidate;
import com.muthukumarasamy.interviewpanel.startinterview.StartInterview;
import com.muthukumarasamy.interviewpanel.viewcandidates.ViewCandidate;

public class InterviewPanel {

	public static void main(String[] args) {

		InterviewPanel interviewpanel = new InterviewPanel();
		interviewpanel.init();

	}

	private void init() {
		ViewCandidate viewcandidate = new ViewCandidate();
		Scanner mc = new Scanner(System.in);
		int value = 0;
		do {
			System.out.print("----------------------------------------------------\n");
			System.out.print("Options:\n\t1.AddCandidates\n\t2.TotalCandiadates\n\t"
					 + "3.StartInterview\n\t4.CurrentStatus\n\t5.RemainingCandidates\n");
			System.out.print("----------------------------------------------------\n");
			value = mc.nextInt();
			switch (value) {
			case 1:
				AddCandidate addcandidate = new AddCandidate();
				addcandidate.getCandidateInfo();
				break;
			case 2:
				viewcandidate.viewTotalList();
				break;
			case 3:
				StartInterview startinterview= new StartInterview();
				startinterview.startProcess();
				break;
			case 4:
				viewcandidate.getCurrentStatus();
				break;
			case 5:
				viewcandidate.viewGetRemainingList();
				break;

			}
		} while (value != 0);

	}

}

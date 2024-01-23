package com.muthukumarasamy.interviewpanel.startinterview;

import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.muthukumarasamy.interviewpanel.dto.Candidate;
import com.muthukumarasamy.interviewpanel.repository.Repository;

class StartInterviewViemodel {

	
	private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


	public void startInterviewIfNotRunning() {
		Queue<Candidate> candidateQueue = Repository.getInstance().getRemainingList();

		if (!candidateQueue.isEmpty()) {
			scheduler.scheduleWithFixedDelay(() -> {
				Candidate candidate = candidateQueue.poll();
				if (candidate != null) {
					new Thread(new StartInterview(candidate)).start();
				}
			}, 1, 6, TimeUnit.SECONDS);
		}
	}

}

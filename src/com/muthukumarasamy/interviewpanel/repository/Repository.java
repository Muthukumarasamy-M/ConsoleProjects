package com.muthukumarasamy.interviewpanel.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.muthukumarasamy.interviewpanel.dto.Candidate;

public class Repository {

	private Queue<Candidate> list = new LinkedList<>();
	private ArrayList<Candidate> alist = new ArrayList<>();
	private static Repository repository = null;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public ArrayList<Candidate> getTotalList() {
		return alist;
	}

	public void InsertList(Candidate candidate) {
		list.add(candidate);
		alist.add(candidate);
	}

	public Queue<Candidate> getRemainingList() {
		return list;
	}

	public Candidate getCurrentStatus() {
		return list.peek();
	}
}

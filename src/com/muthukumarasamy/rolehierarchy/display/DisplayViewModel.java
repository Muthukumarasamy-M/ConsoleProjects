package com.muthukumarasamy.rolehierarchy.display;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.muthukumarasamy.rolehierarchy.dto.Data;
import com.muthukumarasamy.rolehierarchy.repository.Repository;

public class DisplayViewModel {

	static List<Data> details = new ArrayList<>();
	static List<Data> hdata = new ArrayList<>();

	public void findhdata() {
		String rolename = "CEO";
		details = Repository.getInstance().getDetails();
		ArrayDeque<Data> queue = new ArrayDeque<>();
		for (Data det : details) {
			if (det.getRole().equals(rolename)) {
				queue.add(det);
				hdata.add(det);
				break;
			}
		}
		while (!queue.isEmpty()) {

			Data Currentdata = queue.pop();
			for (Data det : details) {

				if (!det.getReportingto().equals("-") && det.getReportingto().equals(Currentdata.getRole())) {
					queue.add(det);
					hdata.add(det);
				}
			}
		}
		Repository.getInstance().setDetails(hdata);

	}

	public String displayRole() {

		StringBuilder result = new StringBuilder();
		for (Data det : hdata) {

			result.append(det.getRole()).append(", ");
		}
		return result.toString();

	}

	public String displayUser() {

		StringBuilder result = new StringBuilder();
		for (Data det : hdata) {

			result.append(det.getName()).append(" - ").append(det.getRole()).append("\n");
		}

		return result.toString();
	}

	public String displayUserandSub() {
		StringBuilder result = new StringBuilder();
		for (Data det : hdata) {
			result.append(det.getName()).append(" - ");

			int index = hdata.indexOf(det);
			index++;
			while (index < hdata.size()) {
				Data cur = hdata.get(index);
				if (hdata.indexOf(det) == 0 && !cur.getName().equals("-"))
					result.append(cur.getName()).append(" , ");
				else if (det.getRole().equals(cur.getReportingto()) && !cur.getName().equals("-"))
					result.append(cur.getName()).append(" , ");
				index++;
			}
			result.append("\n");
		}
		return result.toString();
	}

	public int countUsersBetween(String User) {
		int count = 0;
		ArrayDeque<Data> queue = new ArrayDeque<>();
		for (Data det : hdata) {

			if (det.getName().equals(User)) {
				queue.add(det);
				break;
			}
		}
		while (!queue.isEmpty()) {
			Data cur = queue.pop();
			if (cur.getReportingto().equals("-"))
				break;
			else
				count++;
			for (Data det : hdata) {
				if (cur.getReportingto().equals(det.getRole()))
					queue.add(det);
			}
		}

		return count;
	}

	public int countUserHeight() {
		String user = hdata.get(hdata.size() - 1).getName();
		return countUsersBetween(user);
	}

	public String commonBoss(String user1, String user2) {

		Data userdata1 = null;
		Data userdata2 = null;
		for (Data det : hdata) {
			if (det.getName().equals(user1) && userdata1 == null)
				userdata1 = det;
			else if (det.getName().equals(user2) && userdata2 == null)
				userdata2 = det;
		}

		if (userdata1.getReportingto().equals(userdata2.getReportingto()))
			return userdata1.getReportingto();
		if (userdata1.getReportingto().equals("CEO") || userdata2.getReportingto().equals("CEO"))
			return "CEO";

		List<String> report1 = findreporting(userdata1);
		List<String> report2 = findreporting(userdata2);
		for (String s : report1) {
			if (report2.contains(s))
				return s;
		}
		return null;
	}

	private List<String> findreporting(Data userdata) {

		List<String> reporting = new ArrayList<>();
		ArrayDeque<Data> queue = new ArrayDeque<>();
		queue.add(userdata);
		while (!queue.isEmpty()) {
			Data cur = queue.pop();

			while (!queue.isEmpty()) {

				Data Currentdata = queue.pop();
				for (Data det : details) {

					if (!det.getReportingto().equals("-") && det.getReportingto().equals(Currentdata.getRole())) {
						queue.add(det);
						reporting.add(det.getReportingto());
					}
				}
			}

		}
		return reporting;

	}
}

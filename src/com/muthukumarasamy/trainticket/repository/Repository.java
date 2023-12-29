package com.muthukumarasamy.trainticket.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.muthukumarasamy.trainticket.dto.User;

public class Repository {
	private static Repository repository = null;
	private List<User> details;
	private static Map<String, Integer> map = new HashMap<>();

	public Repository() {
		initialise();
		readFile();
	}

	public Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;

	}

	private void initialise() {
		details = new ArrayList<>();
		details.add(new User("Kailash", 11, "kailash@gmail.com", "9876543210", "100", "jzhkzrg34"));
		details.add(new User("Karthiga", 12, " karthiga@gmail.com", "9876543211", "90", "jzqsghfz53"));
	}

	public void readFile() {
		String filePath = "C:\\Users\\ramki\\eclipse-workspace\\projects\\src\\com\\muthukumarasamy\\trainticket\\stations.csv";

		try {
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter(",");

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String[] values = line.split(",");
				map.put(values[0], Integer.parseInt(values[1]));
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Integer> getStations() {
		return map;
	}

	public List<User> getDetails() {
		return details;
	}

}

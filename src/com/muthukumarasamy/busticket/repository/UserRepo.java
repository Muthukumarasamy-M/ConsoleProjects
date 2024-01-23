package com.muthukumarasamy.busticket.repository;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.busticket.dto.User;

public class UserRepo {

	private static UserRepo userrepo = null;
	private static final String USER = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\busticket\\files\\USER.json";
	private static final String BUSSTANDS ="C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\busticket\\files\\BUSSTANDS.csv";
	private static List<User> userList = new ArrayList<>();

	public static UserRepo getInstance() {
		if (userrepo == null)
			userrepo = new UserRepo();
		return userrepo;
	}

	public UserRepo() {
		loadfromjson();
	}

	private void loadfromjson() {

		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(USER)));
			JSONArray jsonarray = new JSONArray(jsonString);
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jsonobject = (JSONObject) jsonarray.get(i);
				String username = jsonobject.getString("Username");
				String password = jsonobject.getString("Password");
				userList.add(new User(username, password));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void savetojson() {

		JSONArray jsonarray = new JSONArray();
		for (User data : userList) {
			JSONObject jsonobject = new JSONObject();
			jsonobject.put("Username", data.getUsername());
			jsonobject.put("Password", data.getPassword());
			jsonarray.put(jsonobject);
		}
		try (FileWriter filewriter = new FileWriter(USER);) {
			filewriter.write(jsonarray.toString(2));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<User> getUserList() {
		return userList;
	}

	public void SetUserList(List<User> user) {
		userList = user;
		savetojson();
	}

	public List<String[]> readCSV() {
        List<String[]> csvData = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(BUSSTANDS))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] fields = line.split(",");
                csvData.add(fields);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return csvData;
    }
}

package com.muthukumarasamy.rolehierarchy.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.rolehierarchy.dto.Data;

public class Repository {

	private static Repository repository = null;
	private static final String ALLROLE = "C:\\Users\\ramki\\git\\repository\\projects\\src\\com\\muthukumarasamy\\rolehierarchy\\file\\Role.json";
	private static List<Data> details = new ArrayList<>();

	public Repository() {
		loadFromJson();
	}

	public void addJson(Data data) {

		if (data.getName() == null) {
			data.setName("-");
		}
		if (data.getReportingto() == null) {
			data.setReportingto("-");
		}

		details.add(data);
		savetojson();
	}

	public static Repository getInstance() {

		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public int loadFromJson() {
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(ALLROLE)));
			JSONArray jsonArray = new JSONArray(jsonString);
			if (jsonArray.length() == 0) {
				return -1;
			} else {
				details.clear();
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					String name = jsonObject.getString("name");
					String role = jsonObject.getString("role");
					String reportingto = jsonObject.getString("reportingto");

					Data data = new Data(role, reportingto, name);
					details.add(data);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private void savetojson() {
		JSONArray jsonArray = new JSONArray();
		for (Data data : details) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", data.getName());
			jsonObject.put("role", data.getRole());
			jsonObject.put("reportingto", data.getReportingto());
			jsonArray.put(jsonObject);
		}

		try (FileWriter fileWriter = new FileWriter(ALLROLE)) {
			fileWriter.write(jsonArray.toString(2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Data> getDetails() {

		return details;
	}

	public void setDetails(List<Data> detail) {
		details = detail;
		savetojson();
	}

}

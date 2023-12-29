package com.muthukumarasamy.contactlist.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.muthukumarasamy.contactlist.dto.Contact;

public class Repository {
	private static Repository repository = null;
	private static List<Contact> contacts;

	public static final String CONTACTSJSON = "C:\\Users\\ramki\\eclipse-workspace\\projects\\src\\com\\muthukumarasamy\\contactlist\\CONTACTS.json";

	private Repository() {
		contacts = new ArrayList<>();
		loadContactsFromJson();

	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();

		return repository;

	}

	public void addContacts(Contact details) {

		contacts.add(details);
		Collections.sort(contacts, Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));

		loadContactsToJson(contacts);
	}

	public List<Contact> getList() {
		return contacts;
	}

	public void loadContactsToJson(List<Contact> contacts) {
		JSONArray jsonContacts = new JSONArray();
		for (Contact contact1 : contacts) {
			jsonContacts.put(contact1.toJson());
		}
		try (FileWriter fileWriter = new FileWriter(CONTACTSJSON)) {
			fileWriter.write(jsonContacts.toString(2)); // 2 is for indentation
			System.out.println("Contacts updated");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void loadContactsFromJson() {
		try {

			String json = new String(Files.readAllBytes(Paths.get(CONTACTSJSON)));
			JSONArray jsonContacts = new JSONArray(json);

			contacts.clear();
			for (int i = 0; i < jsonContacts.length(); i++) {
				JSONObject jsonContact = jsonContacts.getJSONObject(i);
				Contact contact = Contact.fromJson(jsonContact);
				contacts.add(contact);
			}
			Collections.sort(contacts, Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));
		} catch (IOException e) {
			System.out.println("No existing contacts.json file found.");
		}
	}

}

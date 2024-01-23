package com.muthukumarasamy.rolehierarchy.add;

import java.util.List;

import com.muthukumarasamy.rolehierarchy.dto.Data;
import com.muthukumarasamy.rolehierarchy.repository.Repository;

public class AddViewModel {

	List<Data> details = Repository.getInstance().getDetails();

	public void addSubrole(Data data) {

		details.add(data);
		Repository.getInstance().setDetails(details);

	}

	public void addUser(String user, String role) {

		for (Data data : details) {
			if (data.getRole().equals(role)) {
				if (data.getName().length()==1)
					data.setName(user);
				else
					data.setName(data.getName() + "," + user);
			}
		}
		Repository.getInstance().setDetails(details);

	}

}

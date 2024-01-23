package com.muthukumarasamy.rolehierarchy.delete;

import java.util.List;

import com.muthukumarasamy.rolehierarchy.dto.Data;
import com.muthukumarasamy.rolehierarchy.repository.Repository;

public class DeleteViewModel {

	List<Data> details = Repository.getInstance().getDetails();

	public void deleterole(String role, String tranf) {

		String str = null;
		int index = -1, tindex = -1;
		for (Data data : details) {

			if (data.getRole().equals(role)) {
				str = data.getReportingto();
				index = details.indexOf(data);
			}
			if (data.getReportingto() != "-" && data.getReportingto().equals(role)) {
				data.setReportingto(tranf);
			}
			if (data.getRole().equals(tranf)) {
				tindex = details.indexOf(data);
			}
		}
		if (index != -1)
			details.remove(index);
		if (tindex != -1 && str != null) {
			details.get(tindex - 1).setReportingto(str);
		}
		Repository.getInstance().setDetails(details);
	}

	public void deleteuser(String role, String tranf) {

		int index = -1, tindex = -1;
		String name = "";
		for (Data data : details) {

			if (data.getRole().equals(role)) {
				name = data.getName();
				index = details.indexOf(data);
				
			}
		}
		if(index!=-1)
			details.remove(index);
		for (Data data : details) {

			if (data.getRole().equals(tranf)) {
				data.setName(name);
			}
		}
		Repository.getInstance().setDetails(details);
	}

}

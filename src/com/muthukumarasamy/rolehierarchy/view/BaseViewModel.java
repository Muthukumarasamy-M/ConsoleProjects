package com.muthukumarasamy.rolehierarchy.view;

import com.muthukumarasamy.rolehierarchy.dto.Data;
import com.muthukumarasamy.rolehierarchy.repository.Repository;

public class BaseViewModel {



	public void addFirst(Data data) {
		Repository.getInstance().addJson(data);
	}

	public int checkRoot() {
		
		return Repository.getInstance().loadFromJson();
	}

}

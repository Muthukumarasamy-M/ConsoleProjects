package com.muthukumarasamy.busticket.baseview;

import java.util.ArrayList;
import java.util.List;

import com.muthukumarasamy.busticket.dto.User;
import com.muthukumarasamy.busticket.repository.UserRepo;

public class HomeViewModel {
	List<User> userList = new ArrayList<>();
	public boolean validateName(String name) {
		if (name.matches("^[a-zA-Z0-9_]{6,20}$"))
			return true;
		return false;
	}

	public boolean validatePassword(String password) {
		if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,16}$"))
			return true;
		return false;
	}

	public boolean ispresent(User data) {
		userList = UserRepo.getInstance().getUserList();
		for (User user : userList) {
			if (user.getUsername().equals(data.getUsername()) && user.getPassword().equals(data.getPassword()))
				return true;
		}
		return false;
	}

	public void adduser(User data) {
		userList.add(data);
		UserRepo.getInstance().SetUserList(userList);
	}
}

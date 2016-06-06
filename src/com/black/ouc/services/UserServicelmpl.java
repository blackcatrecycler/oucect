package com.black.ouc.services;

import java.util.ArrayList;
import java.util.List;

import com.black.ouc.daos.UserDao;
import com.black.ouc.daos.UserDaolmpl;
import com.black.ouc.domains.User;

public class UserServicelmpl implements UserService {

	public int IsMatching(String account, String password) {
		// TODO Auto-generated method stub
		UserDao us = new UserDaolmpl();
		List<User> users = new ArrayList<User>();
		users=us.getlist(account, password);
		if(users.size()>0){
			User usa = users.get(0);
			return usa.getId();
		}
		else{
			return 0;
		}
	}

	public User getMessage(int id) {
		// TODO Auto-generated method stub
		UserDao us = new UserDaolmpl();
		User user = us.getuser(id);
		return user;
	}

	public int IsHava(String account) {
		// TODO Auto-generated method stub
		UserDao us = new UserDaolmpl();
		return us.IsHave(account);
	}

}

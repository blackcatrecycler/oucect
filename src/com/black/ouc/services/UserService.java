package com.black.ouc.services;

import com.black.ouc.domains.User;

public interface UserService {
	int IsMatching(String account,String password);
	User getMessage(int id);
	int IsHava(String account);
}

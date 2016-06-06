package com.black.ouc.daos;

import java.util.List;

import com.black.ouc.domains.User;

public interface UserDao {
	 List<User> getlist();
	 List<User> getlist(int num);
	 List<User> getlist(String account, String password);
	 int IsHave(String account);
	 User getuser(int id);
	 void add(String account,String password,String mail,int roomnum );
	 void add(String account,String password,String mail);
	 void del(int id);
	 void update(int id,String password,String mail,int roomnum );
}

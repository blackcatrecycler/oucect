package com.black.ouc.daos;

import java.util.List;

import com.black.ouc.domains.Room;

public interface RoomDao {
	public List<Room> getlist();
	public List<Room> getlist(String house,String room,String area);
	public void add(String house,String room,String area);
	public void update();
}

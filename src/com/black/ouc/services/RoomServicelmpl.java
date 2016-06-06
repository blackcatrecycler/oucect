package com.black.ouc.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.black.ouc.daos.RoomDao;
import com.black.ouc.daos.RoomDaolmpl;
import com.black.ouc.domains.Room;
import com.black.ouc.servlet.pythoncode;

public class RoomServicelmpl implements RoomService {

	public double query(String area, String house, String room) {
		// TODO Auto-generated method stub
		double ect = 0;
		RoomDao rom = new RoomDaolmpl();
		List<Room> ro =new ArrayList<Room>();
		ro = rom.getlist(house,room,area);
		if(ro.size()<=0){
			rom.add(house, room, area);
			pythoncode py = new pythoncode();
			try {
				py.update();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ro = rom.getlist(house,room,area);
			for (Room room2 : ro) {
				ect=room2.getEct();
			}
			return ect;
		}
		else{
			for (Room room2 : ro) {
				ect=room2.getEct();
			}
			return ect;
		}
	}

}

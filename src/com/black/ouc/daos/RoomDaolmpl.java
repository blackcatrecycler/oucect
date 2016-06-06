package com.black.ouc.daos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.black.ouc.domains.Room;
import com.black.ouc.domains.User;
import com.black.ouc.servlet.pythoncode;
import com.black.ouc.utils.HibernateUtil;

public class RoomDaolmpl implements RoomDao {
	private  SessionFactory factory = HibernateUtil.getSessionFactory();
	public List<Room> getlist() {
		List<Room> list = new ArrayList<Room>();
		Transaction tr = null;
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  rooms where ect< 20";
			Query query = session.createQuery(sql);

			list = (List<Room>)query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public List<Room> getlist(String house, String room, String area) {
		List<Room> list = new ArrayList<Room>();
		Transaction tr = null;
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  Room where house = '"+house+"' and room = '"+room+"' and  area = '"+area+"'";
			Query query = session.createQuery(sql);

			list = (List<Room>)query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public void add(String house, String room, String area) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		session.beginTransaction();  
        
        Room user = new Room();  
        user.setArea(area);  
        user.setHouse(house);  
        user.setRoom(room);  
        user.setId(1);  
        session.save(user);  
        session.getTransaction().commit();
        session.close();
	}

	public void update() {
		// TODO Auto-generated method stub
		pythoncode dd=new pythoncode();
		try {
			dd.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}

package com.black.ouc.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.black.ouc.domains.User;
import com.black.ouc.utils.HibernateUtil;

public class UserDaolmpl implements UserDao {
	private  SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public List<User> getlist(){
		List<User> list = new ArrayList<User>();
		Transaction tr = null;
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  User";
			Query query = session.createQuery(sql);

			list = (List<User>)query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	public List<User> getlist(int num){
		List<User> list = new ArrayList<User>();
		Transaction tr = null;
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  User where roomnum="+String.valueOf(num);
			Query query = session.createQuery(sql);

			list = (List<User>)query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	public List<User> getlist(String account, String password){
		List<User> list = new ArrayList<User>();
		Transaction tr = null;
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  User where account="+account+" and password="+password;
			Query query = session.createQuery(sql);

			list = (List<User>)query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	public void add(String account,String password,String mail,int roomnum){
		Session session = factory.openSession();
		session.beginTransaction();  
        
        User user = new User();  
        user.setAccount(account);  
        user.setPassword(password);  
        user.setMail(mail);  
        user.setRoomnum(roomnum);  
        session.save(user);  
        session.getTransaction().commit();
        session.close();
	}
	public void del(int id){
		Session session = factory.openSession();
		session.beginTransaction(); 
		User user=(User)session.load(User.class, session);
		user.setId(id); //É¾³ýid=16µÄÏî
		session.delete(user);
		session.getTransaction().commit();
	}
	public void update(int id,String password,String mail,int roomnum ){
		Session session = factory.openSession();
		session.beginTransaction();  
        
        User user=(User)session.load(User.class, session);  
        user.setId(id);
        user.setPassword(password);
        user.setMail(mail);
        user.setRoomnum(roomnum);
        session.update(user);  
        session.getTransaction().commit();
        session.close();
	}
	public User getuser(int id) {
		List<User> list = new ArrayList<User>();
		Transaction tr = null;
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  User where id="+String.valueOf(id);
			Query query = session.createQuery(sql);

			list = (List<User>)query.list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		User us=list.get(0);		
		return us;
	}
	public int IsHave(String account) {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		Transaction tr = null;
		int id =0; 
		Session session = factory.openSession();
		try {
			tr = session.beginTransaction();
			// tr.begin();
			String sql = "from  User where account= '"+account+"'";
			Query query = session.createQuery(sql);

			list = (List<User>)query.list();
			tr.commit();
			User us=list.get(0);
			id=1;
		} catch (Exception e) {
			e.printStackTrace();
			id=0;
		} finally {
			session.close();
		}		
		return id;
	}
	public void add(String account, String password, String mail) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		session.beginTransaction();  
        
        User user = new User();  
        user.setAccount(account);  
        user.setPassword(password);  
        user.setMail(mail);   
        session.save(user);  
        session.getTransaction().commit();
        session.close();
	}
}

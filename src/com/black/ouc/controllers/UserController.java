package com.black.ouc.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.black.ouc.daos.UserDao;
import com.black.ouc.daos.UserDaolmpl;
import com.black.ouc.services.RoomService;
import com.black.ouc.services.RoomServicelmpl;
import com.black.ouc.services.UserService;
import com.black.ouc.services.UserServicelmpl;
import com.black.ouc.servlet.javamail;
import com.opensymphony.xwork2.ActionSupport;

public class UserController extends ActionSupport{
	public String index(){
		System.out.println("haha");
		return SUCCESS;
	}
	
	private javax.servlet.http.HttpServletResponse response;
	
	public String query(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String method = ServletActionContext.getRequest().getMethod();
		if("POST".equals(method)){
			String area = request.getParameter("area");
			String house = request.getParameter("house");
			String room = request.getParameter("room");
			RoomService ro = new RoomServicelmpl();
			double ect = ro.query(area, house, room);
			String ect1;
			if(ect<20){
				ect1="电量剩余"+String.valueOf(ect)+",请及时充电费";
			}
			else{
				ect1="电量充足";
			}
			HttpSession hs = ServletActionContext.getRequest().getSession();
			hs.setAttribute("house", house);
			hs.setAttribute("area", area);
			hs.setAttribute("room", room);
			hs.setAttribute("ect1", ect1);
			
		}
		return SUCCESS;
	}
	
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();
		HttpSession session = request.getSession();
		if("POST".equals(method)){
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			UserService us = new UserServicelmpl();
			if(us.IsMatching(account, password)!=0){

				session.setAttribute("id", String.valueOf(us.IsMatching(account, password)));
				session.setAttribute("account", account);
				
				return "go";
			}
			else{
				return ERROR;
			}
		}else{
			try{
				int id=0;
				id=Integer.parseInt(session.getAttribute("id").toString());
				if(id==0){
					return SUCCESS;
				}
			}catch(Exception e){
				
			}
		}
		return SUCCESS;
	}
	public String mailpost() throws IOException{
		javamail ma = new javamail();
		ma.update();
		return SUCCESS;
	}
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try{
			int id = 0;
			id=Integer.parseInt(session.getAttribute("id").toString());
			if(id!=0){
				return "go";
			}
		}
		catch (Exception e){
			
		}
		return SUCCESS;
	}
	
	public String editor(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try{
			int id = 0;
			id=Integer.parseInt(session.getAttribute("id").toString());
			if(id!=0){
				return "success";
			}
		}catch(Exception e){
		}
		return ERROR;
	}
	
	public String register() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();
		if("POST".equals(method)){
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			UserDao us = new UserDaolmpl();
			us.add(account, password, mail);
			return "ok";
		}
		return SUCCESS;
	}
	
	public String exit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("account");
		session.removeAttribute("id");
		return SUCCESS;
	}
	
}

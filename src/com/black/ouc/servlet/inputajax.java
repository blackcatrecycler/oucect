package com.black.ouc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.black.ouc.services.UserService;
import com.black.ouc.services.UserServicelmpl;


@WebServlet(name="inputajax",urlPatterns="/inputajax")
public class inputajax extends HttpServlet{
	public inputajax(){}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		String account=request.getParameter("account");
		UserService us = new UserServicelmpl();
		int i =us.IsHava(account);
		String re;
		if(i==0){
			re = "{"+"\"text\" : \"此用户名可以使用\""+"}";
		}else{
			re = "{"+"\"text\" : \"此用户名已存在，请更换\""+"}";
		}
		PrintWriter out = response.getWriter();
		out.write(re);
		out.flush();
		out.close();
	}
}

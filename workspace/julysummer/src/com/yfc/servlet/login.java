package com.yfc.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yfc.dao.AdminDao;
import com.yfc.valueBean.AdminBean;

public class login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public String handleString(String s){
		try{
			byte bb[]=s.getBytes();
			s=new String(bb);
		}catch(Exception ex){}
		return s;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminBean adBean=null;
		String backNews="";
		HttpSession session=request.getSession(true);
		adBean=(AdminBean)session.getAttribute("login");
		System.out.println(adBean);
		if(adBean==null){
			adBean=new AdminBean();
			String logname=request.getParameter("username").trim();
			String password=request.getParameter("password").trim();
			System.out.println(logname);System.out.println(password);
			logname=handleString(logname);password=handleString(password);
		
			if(logname.equals(adBean.getUserName())){
				backNews=logname+"已经登录了";
				System.out.println(backNews);
				adBean.setBackNews(backNews);
			}else{
				boolean boo=(logname.length()>0)&&(password.length()>0);
					AdminDao ad=new AdminDao();
					if(boo){
						boolean m=ad.isExist(logname,password);
						if(m){
							backNews="登录成功";
							adBean.setBackNews(backNews);
							adBean.setUserName(logname);
							session.setAttribute("login",adBean);
							response.sendRedirect("/julysummer/");
						}else{
							backNews="您输入的用户名不存在，或密码不般配";
							request.setAttribute("backNews", backNews);
							RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
							dispatcher.forward(request, response);
						}
					}else{
						backNews="您输入的用户名不存在，或密码不般配";
						request.setAttribute("backNews", backNews);
						RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
						dispatcher.forward(request, response);
					}
					System.out.println(backNews);
				}
			}else{
				response.sendRedirect("/julysummer/");
			}
		}
}

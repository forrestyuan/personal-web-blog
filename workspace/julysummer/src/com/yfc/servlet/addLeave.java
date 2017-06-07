package com.yfc.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.LeaveDao;
import com.yfc.toolBean.DateGet;
import com.yfc.valueBean.LeaveBean;

public class addLeave extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("name");//user
		String userEmail=request.getParameter("email");//userEmail
		String topic=request.getParameter("topic");
		String content=request.getParameter("content");
		String time=DateGet.changeTime(new Date());
		String state="yes";
		LeaveBean lb=new LeaveBean();
		lb.setName(userName);
		lb.setEmail(userEmail);
		lb.setTopic(topic);
		lb.setContent(content);
		lb.setState(state);
		lb.setTime(time);
		
		LeaveDao ld=new LeaveDao();
		boolean isSuccess=ld.operationLeaveWord("add", lb);
		if(isSuccess){
			response.sendRedirect("leave");
		}
	}

}

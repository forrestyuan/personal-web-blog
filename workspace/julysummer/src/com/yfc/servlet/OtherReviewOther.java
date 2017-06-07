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

public class OtherReviewOther extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String time=DateGet.changeTime(new Date());
			String state="yes";
			String topic=request.getParameter("topic");
			String content=request.getParameter("leaveword");
			LeaveBean lb=new LeaveBean();
			lb.setContent(content);
			lb.setName(name);
			lb.setEmail(email);
			lb.setTopic(topic);
			lb.setState(state);
			lb.setTime(time);
			LeaveDao ld=new LeaveDao();
			ld.operationLeaveWord("add",lb);
			response.sendRedirect("leave");
	}

}

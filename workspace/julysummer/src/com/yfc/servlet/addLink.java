package com.yfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.LinkDao;
import com.yfc.valueBean.LinkBean;

public class addLink extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String linkurl=request.getParameter("linkurl");
		String linkname=request.getParameter("linkName");
		
		LinkDao lkd=new LinkDao();
		LinkBean lb=new LinkBean();
		lb.setLinkLoveURL(linkurl);
		lb.setLinkName(linkname);
		lkd.addLink(lb);
		
		response.sendRedirect("manage?go=0&id=0");
	}
}

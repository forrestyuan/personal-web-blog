package com.yfc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.LeaveDao;
import com.yfc.dao.LinkDao;
import com.yfc.valueBean.LeaveBean;
import com.yfc.valueBean.LinkBean;

public class leave extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LeaveDao ld=new LeaveDao();
		List<LeaveBean> lbList=ld.queryLeaveWord();
		request.setAttribute("lbList",lbList);
		/*
		 * 列出所有友情链接
		 */
		 LinkDao linkDao=new LinkDao();
		 	List<LinkBean> lList=linkDao.queryLink();
		 	request.setAttribute("allLink",lList);
		RequestDispatcher rdp=request.getRequestDispatcher("front/leave.jsp");
		rdp.forward(request, response);
	}

}

package com.yfc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.LightDao;
import com.yfc.dao.LinkDao;
import com.yfc.valueBean.LinkBean;
import com.yfc.valueBean.PhotoBean;

public class light extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LightDao ptd=new LightDao();
			List<PhotoBean> listpb=ptd.queryAllPic();
			request.setAttribute("allPic",listpb);
			/*
			 * 列出所有友情链接
			 */
			 LinkDao linkDao=new LinkDao();
			 	List<LinkBean> lbList=linkDao.queryLink();
			 	request.setAttribute("allLink",lbList);
			RequestDispatcher rdp=request.getRequestDispatcher("front/light.jsp");
			rdp.forward(request, response);	
		
	}

}

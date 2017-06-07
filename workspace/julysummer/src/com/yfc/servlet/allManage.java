package com.yfc.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.ArticleDao;
import com.yfc.toolBean.DateGet;
import com.yfc.valueBean.ArticleBean;

public class allManage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ArticleDao articleDao=new ArticleDao();
		String content=request.getParameter("content");
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String description=request.getParameter("description");
		String time=DateGet.changeTime(new Date());
		int viewCounts=0;
		ArticleBean atb=new ArticleBean();
		atb.setTitle(title);
		atb.setContent(content);
		atb.setDescription(description);
		atb.setType(type);
		atb.setViewCounts(viewCounts);
		atb.setTime(time);
		articleDao.operationArticle("add", atb);
	response.sendRedirect("manage?go=ok&id=null");
	}

}

package com.yfc.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.DiscussDao;
import com.yfc.toolBean.DateGet;
import com.yfc.toolBean.StringTool;
import com.yfc.valueBean.DiscussBean;

public class addDiscussServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String discussContent=request.getParameter("ArticleDiscuss");
		String articleId=request.getParameter("id");
		String discussUsername=request.getParameter("dicussUserName");
		String dicussUserEmail=request.getParameter("discussUserEmail");
		String time=DateGet.changeTime(new Date());
		//将得到得信息封装在valulebean中
		DiscussBean dsb=new DiscussBean();
			dsb.setArticleId(Integer.parseInt(articleId));
			dsb.setName(discussUsername);
			dsb.setEmail(dicussUserEmail);
			dsb.setContent(discussContent);
			dsb.setTime(time);
		//将封装好的信心写入数据库
		DiscussDao dd=new DiscussDao();
		boolean isSuccess=dd.addDiscuss(dsb);
		if(isSuccess){
			response.sendRedirect("detail?id="+articleId);
		}else{
			String array[]=new String[]{"addDiscuss","false"};
			request.setAttribute("which",array);
			RequestDispatcher rdp=request.getRequestDispatcher("/front/failure.jsp");
			rdp.forward(request, response);
		}
		System.out.println(discussContent);
		
	}

}

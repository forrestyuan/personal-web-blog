package com.yfc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.ArticleDao;
import com.yfc.valueBean.ArticleBean;

public class goSearch extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String search1=request.getParameter("search");
			System.out.println(search1);
			ArticleDao atd=new ArticleDao();
			List<ArticleBean> articleList=null;
			articleList=atd.getTosearch(search1);
			request.setAttribute("searchArticle", articleList);
		if(articleList!=null){
			RequestDispatcher rdp=request.getRequestDispatcher("front/result.jsp");
			rdp.forward(request, response);
		}else{
			RequestDispatcher rdp=request.getRequestDispatcher("front/error.jsp");
			rdp.forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

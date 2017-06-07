package com.yfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.AdminDao;
import com.yfc.dao.ArticleDao;
import com.yfc.dao.DiscussDao;
import com.yfc.dao.LinkDao;
import com.yfc.valueBean.ArticleBean;
import com.yfc.valueBean.LinkBean;

public class learn extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleDao atd=new ArticleDao();
		DiscussDao dd=new DiscussDao();
		String type=request.getParameter("type");
		List<ArticleBean> articleList=null;
		if(type==null){
			articleList=atd.queryArticle(null, null);
			request.setAttribute("main","所有：");
		}else{
			articleList=atd.queryArticle(null,type);
			request.setAttribute("main",type);
		}
		//文章列表
		 for(ArticleBean i:articleList){
			int countDiscuss=dd.queryDiscussTimes(""+i.getArticleId());
			i.setDiscussCounts(countDiscuss);
		}
		request.setAttribute("articleList",articleList);			//将文章列表保存到attribute中
		//类型列表
		List<ArticleBean> typeList=atd.queryArticleType();			
		request.setAttribute("typeList",typeList);					//将类型列表保存到attribute中
		
		/*
		 * 列出所有友情链接
		 */
		 LinkDao linkDao=new LinkDao();
		 	List<LinkBean> lbList=linkDao.queryLink();
		 	request.setAttribute("allLink",lbList);
		RequestDispatcher rdp=request.getRequestDispatcher("/front/learn.jsp");
		rdp.forward(request, response);
	}

}

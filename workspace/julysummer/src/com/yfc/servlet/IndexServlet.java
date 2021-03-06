package com.yfc.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.yfc.dao.ShowByPage;
import com.yfc.valueBean.AdminBean;
import com.yfc.valueBean.ArticleBean;
import com.yfc.valueBean.LinkBean;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1145631623516154435L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 文章显示，从数据库读取前15条记录保存到 articleList 中。
		 * 云标签显示，从数据库中读取所有标签，按标签分组，保存到 TypeList中。
		 * 博主信息，从数据库读取博主信息并保存到adminInfo中。
		 */
		ArticleDao atd=new ArticleDao();
		AdminDao ad=new AdminDao();
		DiscussDao dd=new DiscussDao();
		
		List<ArticleBean> articleList=atd.queryHotArticle(6); //文章列表
			for(ArticleBean i:articleList){
				int countDiscuss=dd.queryDiscussTimes(""+i.getArticleId());
				i.setDiscussCounts(countDiscuss);
			}
		request.setAttribute("articleList",articleList);			//将文章列表保存到attribute中
		
		List<ArticleBean> typeList=atd.queryArticleType();			//类型列表
		request.setAttribute("typeList",typeList);					//将类型列表保存到attribute中
			
		AdminBean adb=ad.queryAdminInfo();							//博主信息
		request.setAttribute("adminInfo",adb);						//将博主信息保存到attribute中

		/*
		 * 列出所有友情链接
		 */
		 LinkDao linkDao=new LinkDao();
		 	List<LinkBean> lbList=linkDao.queryLink();
		 	request.setAttribute("allLink",lbList);
		 	
		RequestDispatcher rdp=request.getRequestDispatcher("/front/frontindex.jsp");
		rdp.forward(request, response);
	
	}
}

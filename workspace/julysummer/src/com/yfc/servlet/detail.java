package com.yfc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yfc.dao.ArticleDao;
import com.yfc.dao.DiscussDao;
import com.yfc.dao.LeaveDao;
import com.yfc.dao.LinkDao;
import com.yfc.valueBean.ArticleBean;
import com.yfc.valueBean.DiscussBean;
import com.yfc.valueBean.LeaveBean;
import com.yfc.valueBean.LinkBean;

public class detail extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//获得文章ID
		String id=request.getParameter("id");
		//得到articleId为id的文章
		ArticleDao atd=new ArticleDao();	//ArticleDao
		DiscussDao dd=new DiscussDao();		//DiscussDao
		LeaveDao ld=new LeaveDao();			//LeaveDao
		
		//文章浏览次数+1
		ArticleBean temp=new ArticleBean();
		temp.setArticleId(Integer.parseInt(id));
		atd.operationArticle("readtimes",temp);
		//得到文章详细内容
		List<ArticleBean> artiList=atd.queryArticle(id, null);
		ArticleBean atb=artiList.get(0);
			request.setAttribute("articleDetails",atb);
		//得到评论数
		int discussCount=dd.queryDiscussTimes(id);
			request.setAttribute("discussCounts",discussCount);
		/*查询该篇文章的评论*/
		List<DiscussBean> discussList=dd.queryDiscussContent(id);
			request.setAttribute("discussList",discussList);
		//类型列表	
		List<ArticleBean> typeList=atd.queryArticleType();			
			request.setAttribute("typeList",typeList);					//将类型列表保存到attribute中
		/*热门文章前*/
		List<ArticleBean> hotArticle=atd.queryHotArticle(6);
			request.setAttribute("hotArticle", hotArticle);
		/*近期留言*/
		List<LeaveBean> latestLeave=ld.querySomeLeaveWord(8);
			request.setAttribute("latestLeave", latestLeave);
		/*添加评论*/
		DiscussBean addDiscuss=new DiscussBean();
		/*
		 * 列出所有友情链接
		 */
		 LinkDao linkDao=new LinkDao();
		 	List<LinkBean> lbList=linkDao.queryLink();
		 	request.setAttribute("allLink",lbList);
		//跳转到details.jsp界面
		RequestDispatcher rdp=request.getRequestDispatcher("/front/details.jsp");
		rdp.forward(request, response);
	}

}

package com.yfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yfc.dao.ShowByPage;
import com.yfc.toolBean.changeCoding;
import com.yfc.valueBean.ArticleBean;

public class loadMore extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String require=request.getParameter("pageSize");
		if(require!=null){
			ShowByPage SBP=new ShowByPage();
			int pageAll=SBP.pager();
			pageAll=pageAll%6==0?(pageAll/6):(pageAll/6+1);
			response.setHeader("Access-Control-Allow-Origin","*");
			response.setContentType("text/html;charSet=UTF-8");
			PrintWriter out=response.getWriter();
			out.println(pageAll);
			out.flush();
			out.close();
		}else{
		int m=Integer.parseInt(request.getParameter("start"));
		ShowByPage sbp=new ShowByPage();		
		List<ArticleBean> page=sbp.pager(6,m);	//查询分页数据
		List<String>result=new ArrayList<String>();//结果
		for(ArticleBean i:page){
			String indexPage="<div class=\"article\">" +
								"<h2 class=\"h2\">"+changeCoding.changeCode(i.getTitle())+"</h2>" +
								"<div class=\"article_Info\">" +
									"<span>"+changeCoding.changeCode("文章类型")+":"+changeCoding.changeCode(i.getType())+"</span>" +
									"<span>"+changeCoding.changeCode("发布日期")+":"+changeCoding.changeCode(i.getTime())+"</span>" +
									"<span>"+changeCoding.changeCode("浏览数")+":"+i.getViewCounts()+"</span>" +
									"<span>"+changeCoding.changeCode("评论数")+":"+i.getDiscussCounts()+"</span>" +
								"</div>" +
								"<p>"+changeCoding.changeCode(i.getDescription())+"</p>" +
								"<p><a class=\"btn btn-success\" href=\"/julysummer/servlet/detail?id=4\" role=\"button\">"+changeCoding.changeCode("详细阅读")+"&raquo;</a></p>" +
							"</div>";
			result.add(indexPage);
		}
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/html;charSet=UTF-8");
		PrintWriter out = response.getWriter();
		for(String re:result){out.println(re);}
		out.flush();
		out.close();
	}
	}
}

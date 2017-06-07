package com.yfc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yfc.dao.AdminDao;
import com.yfc.dao.ArticleDao;
import com.yfc.dao.DiscussDao;
import com.yfc.dao.LeaveDao;
import com.yfc.dao.LightDao;
import com.yfc.dao.LinkDao;
import com.yfc.toolBean.MD5;
import com.yfc.valueBean.AdminBean;
import com.yfc.valueBean.ArticleBean;
import com.yfc.valueBean.DiscussBean;
import com.yfc.valueBean.LeaveBean;
import com.yfc.valueBean.LinkBean;
import com.yfc.valueBean.PhotoBean;

public class manage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置接收参数编码格式
		//接收并修改博主信息
		AdminDao ad=new AdminDao();
		AdminBean adb=ad.queryAdminInfo();	
		String username=request.getParameter("username");
		String qq=request.getParameter("qq");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String password=request.getParameter("password");
		if(username!=null&&qq!=null&&email!=null&&sex!=null&&password!=null&&
		   !username.replaceAll(" ","").equals("")&&!qq.replaceAll(" ","").equals("")&&
		   !email.replaceAll(" ","").equals("")&&!sex.replaceAll(" ","").equals("")&&
		   !password.replaceAll(" ","").equals(""))
		{
			AdminBean updateAdb=new AdminBean();
			updateAdb.setEmail(email);
			updateAdb.setQq(qq);
			updateAdb.setUserName(username);
			updateAdb.setSex(sex);
			updateAdb.setPassword(new MD5().getMD5ofStr(password));
			boolean isChange=ad.changeAdministrator(updateAdb);
			if(isChange==true){
				HttpSession session=request.getSession(true);
				AdminBean tmpAdb=(AdminBean) session.getAttribute("login");
				if(tmpAdb!=null){
					session.removeAttribute("login");
				}
				response.sendRedirect("login.jsp");
			}else{						
				request.setAttribute("adminInfo",adb);//将博主信息保存到attribute中
				request.setAttribute("back","修改管理员信息失败");
				RequestDispatcher rdp=request.getRequestDispatcher("admin/manageCenter.jsp");
				rdp.forward(request, response);
			}
		}else{
			/********************************************************************/
			/*接收参数区*/
			 String mygo=request.getParameter("go");
			 String id=request.getParameter("id");
			 ArticleBean mysingle=new ArticleBean();
			 LeaveBean myLeaveSingle=new LeaveBean();
			 if(mygo.equalsIgnoreCase("article")){
				 mysingle.setArticleId(Integer.parseInt(id));
				 ArticleDao articleDao=new ArticleDao();
				 DiscussDao diss=new DiscussDao();
				 diss.deletesomeAllDiscuss(id);
				 articleDao.operationArticle("delete",mysingle); 
			 }else if(mygo.equalsIgnoreCase("leave")){
				 myLeaveSingle.setLeaveId(Integer.parseInt(id));
				 LeaveDao leaveDao=new LeaveDao();
				 leaveDao.operationLeaveWord("delete",myLeaveSingle);
			 }else if(mygo.equalsIgnoreCase("discuss")){
				 DiscussDao discussDao=new DiscussDao();
				 discussDao.deleteDiscuss(id);
			 }else if(mygo.equalsIgnoreCase("link")){
				 LinkDao lkd=new LinkDao();
				 lkd.delteLink(id);
			 }else if(mygo.equalsIgnoreCase("pic")){
				 LightDao ltd=new LightDao();
				 ltd.deletePhoto(id);
			 }
			/**********************************************************************/
			/*
			 * 列出所有友情链接
			 */
			 LinkDao linkDao=new LinkDao();
			 	List<LinkBean> lbList=linkDao.queryLink();
			 	request.setAttribute("allLink",lbList);
			/*
			 * 生成所有链接数
			 */
			 	int linkAll=linkDao.queryLinkAll();
			 	request.setAttribute("linkAll",linkAll);
			 /*
			 *列出所有评论 
			 */
			DiscussDao dd=new DiscussDao();
				List<DiscussBean> discussEach=dd.queryDiscussAll();
				request.setAttribute("discussEach",discussEach);
			/*
			 * 生成评论总数
			 */
				int discussAll=dd.queryAllDiscussTimes();
				request.setAttribute("alldiscuss",discussAll);
			/*
			 *生成网站文章总数
			 */
			ArticleDao atd=new ArticleDao();
				int allArticle=atd.articleAll();
				request.setAttribute("articleAll",allArticle);
			/*
			 * 列出所有文章
			 */
				List<ArticleBean> articleEach=atd.queryArticle(null,null);
				for(ArticleBean i:articleEach){
					int countDiscuss=dd.queryDiscussTimes(""+i.getArticleId());
					i.setDiscussCounts(countDiscuss);
				}
				request.setAttribute("articleEach",articleEach);
			/*
			 * 生成网站总留言数
			 */
			LeaveDao ld=new LeaveDao();
				int allLeave=ld.queryLeaveTimes();
				request.setAttribute("allLeave",allLeave);
			/*
			 * 列出所有留言
			*/
				List<LeaveBean> leaveEach=ld.queryLeaveWord();
				request.setAttribute("leaveEach",leaveEach);
			/*
			 * 列出所有相片
			 */
				LightDao ptd=new LightDao();
				List<PhotoBean> listpb=ptd.queryAllPic();
				request.setAttribute("allPic",listpb);
			/*
			 * 生成相片总数
			 */
				int allPic=ptd.queryCountPic();
				request.setAttribute("countPic",allPic);
			/*
			 * 生成网站收藏数
			 */
			
			
			
			request.setAttribute("adminInfo",adb);
			RequestDispatcher rdp=request.getRequestDispatcher("admin/manageCenter.jsp");
			rdp.forward(request, response);		
		}//将博主信息保存到attribute中
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}

}

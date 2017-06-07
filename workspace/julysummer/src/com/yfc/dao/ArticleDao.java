﻿package com.yfc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yfc.toolBean.CommonADO;
import com.yfc.valueBean.ArticleBean;
public class ArticleDao {
	private CommonADO commonADO=null;
	public ArticleDao(){
		commonADO=CommonADO.getCommonADO();
	}
	/**
	 * @功能 实现对文章进行增、删、改的操作
	 * @参数 oper为一个String类型变量，用来表示要进行的操作；single为ArticleBean类对象，用来存储某个文章的信息
	 * @返回值 boolean型值
	 */
	public boolean operationArticle(String oper, ArticleBean single) {		
		/* 生成SQL语句 */
		String sql = null;
		oper=oper.toLowerCase().trim();
		if(oper.equals("add")){//发表新文章
			sql = "insert into article (title,type,description,content,time,viewCounts) values('"+single.getTitle()+"','"+single.getType()+"','"+single.getDescription()+"','"+single.getContent()+"','"+single.getTime()+"',"+single.getViewCounts()+")";
		}	
		if(oper.equals("modify")){//修改文章
			sql = "update article set title='"+ single.getTitle()+"',type='"+single.getType()+"',description='"+single.getDescription()+"',content='"+single.getContent()+"',time='"+single.getTime()+"',viewCounts="+single.getViewCounts()+"where articleId=" + single.getArticleId();
		}	
		if(oper.equals("delete")){//删除文章
			sql = "delete from article where articleId="+single.getArticleId();
		}
		if(oper.equals("readtimes")){//累加阅读次数
			sql = "update article set viewCounts=viewCounts+1 where articleId="+single.getArticleId();
		}
		/* 执行SQL语句 */	
		return commonADO.executeUpdate(sql)>=1;
	}
	
	/**
	 * @功能 实现查询：文章下的阅读量最多的前指定条文章
	 * @返回值 文章列表 list
	 */
	public List<ArticleBean> queryHotArticle(int num){
		List<ArticleBean> HotArticleList=new ArrayList<ArticleBean>();
		String sql="select top "+num+" * from article order by viewCounts desc";
		ResultSet rs=commonADO.executeSelect(sql);
		try{
			while(rs.next()){
				ArticleBean atb=new ArticleBean();
				atb.setArticleId(rs.getInt("articleId"));
				atb.setTitle(rs.getString("title"));
				atb.setType(rs.getString("type"));
				atb.setDescription(rs.getString("description"));
				atb.setContent(rs.getString("content"));
				atb.setTime(rs.getString("time"));
				atb.setViewCounts(rs.getInt("viewCounts"));
				HotArticleList.add(atb);
				//System.out.println("我在articleADO 下，检查是否有数据："+atb.getDescription());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return HotArticleList;
	}
	/**
	 * @功能 实现查询：所有文章、所有文章下的单篇文章、某类别的前15条文章 、某类别下的单篇文章文章
	 * @参数 id 为一个String类型变量,type为String类型变量
	 * @返回值 文章列表 list
	 */
	public List<ArticleBean> queryArticle(String id,String type){
		List<ArticleBean> articleList=new ArrayList<ArticleBean>();
		String sql=null;
		if(id==null&&type==null){
			//System.out.println("当前测试的是所有文章");
			sql="select * from article";
		}else if(id!=null&&type==null){
			//System.out.println("当前测试的是、所有文章下的单篇文章");
			sql="select * from article where articleId="+Integer.parseInt(id);
		}else if(id==null&&type!=null){
			//System.out.println("当前测试的是、某类别的前15条文章 ");
			sql="select top 15 * from article where type='"+type+"'";
		}else{
			//System.out.println("当前测试的是、某类别下的单篇文章文章");
			sql="select * from article where articleId="+Integer.parseInt(id)+"and type='"+type+"'";
		}
		try{
			ResultSet rs=commonADO.executeSelect(sql);
			while(rs.next()){
				ArticleBean atb=new ArticleBean();
				atb.setArticleId(rs.getInt("articleId"));
				atb.setTitle(rs.getString("title"));
				atb.setType(rs.getString("type"));
				atb.setDescription(rs.getString("description"));
				atb.setContent(rs.getString("content"));
				atb.setTime(rs.getString("time"));
				atb.setViewCounts(rs.getInt("viewCounts"));
				//添加到articlelist中
				articleList.add(atb);
				//System.out.println("我在articleADO 下，检查是否有数据："+atb.getDescription());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return articleList;
	}
	/**
	 * @功能 搜索文章
	 * @参数 str为String类型变量
	 * @返回值 文章列表 list
	 */
	public List<ArticleBean> getTosearch(String str){
		List<ArticleBean> articleList=new ArrayList<ArticleBean>();
		String sql="select * from article where title like '%"+str+"%'";
		ResultSet rs=commonADO.executeSelect(sql);
		try{
			System.out.println("我真的来到这个函数了 并且 Rs为"+rs==null);
			while(rs.next()){
				System.out.println("asdfasdf");
				ArticleBean atb=new ArticleBean();
				atb.setArticleId(rs.getInt("articleId"));
				atb.setTitle(rs.getString("title"));
				atb.setType(rs.getString("type"));
				atb.setDescription(rs.getString("description"));
				atb.setContent(rs.getString("content"));
				atb.setTime(rs.getString("time"));
				atb.setViewCounts(rs.getInt("viewCounts"));
				articleList.add(atb);
				System.out.println("我在articleADO 下，检查是否有数据："+atb.getDescription());
			}
			System.out.println("我都没有进入while循环");
		}catch(Exception e){
			e.printStackTrace();
		}
		return articleList;
	}
	/**
	 * @功能 查询文章总数
	 * @返回值 int型变量
	 */
	public int articleAll(){
		String sql="select count(articleId) as count from article";
		int counts=0;
		try{
			ResultSet rs=commonADO.executeSelect(sql);
			if(rs.next()){
				counts=rs.getInt("count");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return counts;
	}
	/**
	 * @功能 查询所有标签
	 * @返回值 标签List
	 */
	public List<ArticleBean> queryArticleType(){
		List<ArticleBean> typeList=new ArrayList<ArticleBean>();
		String sql="select count(articleId),type from article group by type";
		try{
			ResultSet rs=commonADO.executeSelect(sql);
			while(rs.next()){
				ArticleBean atb=new ArticleBean();
				atb.setType(rs.getString("type"));
				//添加到articlelist中
				typeList.add(atb);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return typeList;
	}
	
}

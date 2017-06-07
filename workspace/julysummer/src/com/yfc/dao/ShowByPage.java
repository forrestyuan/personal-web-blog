package com.yfc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yfc.toolBean.CommonADO;
import com.yfc.valueBean.ArticleBean;

public class ShowByPage {
	private CommonADO commonADO;
	private ResultSet rs;
	private int pageSize=0;
	public ShowByPage(){
		commonADO =CommonADO.getCommonADO();
	}
	public int pager(){
		List<ArticleBean> result=new ArrayList<ArticleBean>();
		String sql="select count(*) as pageAll from article";
		rs=commonADO.executeSelect(sql);
		int pageSize=0;
		try{
			if(rs.next()){
				pageSize=rs.getInt("pageAll");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageSize;
	}
	
	/**
	 * @功能 查询指定位置开始的指定条数
	 * @参数 起始位置n为int型变量,需要条数m为int变量
	 * @返回 List对象
	 */
	public List<ArticleBean> pager(int n,int m){
		String sql="select top "+m+" * from article where articleId not in (select top "+n+" articleId from article order by articleId)order by articleId";
		List<ArticleBean> rsList=new ArrayList<ArticleBean>();
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				ArticleBean atb=new ArticleBean();
				atb.setArticleId(rs.getInt("articleId"));
				atb.setTitle(rs.getString("title"));
				atb.setType(rs.getString("type"));
				atb.setDescription(rs.getString("description"));
				atb.setContent(rs.getString("content"));
				atb.setTime(rs.getString("time"));
				atb.setViewCounts(rs.getInt("viewCounts"));
				System.out.println("woshi fenyequi");
				rsList.add(atb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsList;
	}
	
	/**
	 * @功能 查询指定位置开始的指定类型条数
	 * @参数 起始位置n为int型变量,需要条数m为int变量,type 为String类型变量
	 * @返回 List对象
	 */
	public List<ArticleBean> pagerType(int n,int m,String type){
		String sql="select top "+m+" * from article where articleId not in (select top "+n+" articleId from article order by articleId where type="+type+")order by articleId";
		List<ArticleBean> rsList=new ArrayList<ArticleBean>();
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				ArticleBean atb=new ArticleBean();
				atb.setArticleId(rs.getInt("articleId"));
				atb.setTitle(rs.getString("title"));
				atb.setType(rs.getString("type"));
				atb.setDescription(rs.getString("description"));
				atb.setContent(rs.getString("content"));
				atb.setTime(rs.getString("time"));
				atb.setViewCounts(rs.getInt("viewCounts"));
				System.out.println("woshi fenyequi");
				rsList.add(atb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsList;
	}
}
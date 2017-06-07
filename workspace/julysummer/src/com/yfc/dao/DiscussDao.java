package com.yfc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yfc.toolBean.CommonADO;
import com.yfc.valueBean.DiscussBean;

public class DiscussDao {
	private CommonADO commonADO;
	public DiscussDao(){
		commonADO=commonADO.getCommonADO();
	}
	/**
	 * @功能 删除某评论内容
	 * @参数 id为String类型变量
	 * @返回值 boolean变量
	 */
	public boolean deleteDiscuss(String id) {
		ResultSet rs=null;
		rs=commonADO.executeSelect("select * from discuss where discussId="+Integer.parseInt(id));
		if(rs!=null){
			String sql = "delete from discuss where discussId="+Integer.parseInt(id);
			return commonADO.executeUpdate(sql)>=1;
		}else{
			return true;
		}
	}
	/**
	 * @功能 删除某文章所有评论内容
	 * @参数 id为String类型变量
	 * @返回值 boolean变量
	 */
	public boolean deletesomeAllDiscuss(String articleId) {
		ResultSet rs=null;
		String sql = "delete from discuss where articleId="+Integer.parseInt(articleId);
		return commonADO.executeUpdate(sql)>=0;
	}
	/**
	 * @功能 添加某文章的评论内容
	 * @参数 文章id为String类型变量,评论single为DiscussBean的变量
	 * @返回值 boolean变量
	 */
	public boolean addDiscuss(DiscussBean single){
		String sql="insert into discuss (articleId,name,email,content,time) values("+single.getArticleId()+",'"+single.getName()+"','"+single.getEmail()+"','"+single.getContent()+"','"+single.getTime()+"')";                
		return commonADO.executeUpdate(sql)>0;
	}
	/**
	 * @功能 修改某文章的评论审核状态
	 * @参数 评论id为String类型变量
	 * @返回值 boolean变量
	 */
/*	public boolean checkState(String id){
		String sql="update discuss set state='yes' where discussId="+Integer.parseInt(id);
		return commonADO.executeUpdate(sql)==1;
	}*/
	/**
	 * @功能 查询所有的评论内容
	 * @参数 无
	 * @返回值 discussList为List实例对象
	 */
	public List<DiscussBean> queryDiscussAll(){
		String sql="select * from discuss";
		List<DiscussBean> discussList=new ArrayList<DiscussBean>();
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				DiscussBean discuss=new DiscussBean();
				discuss.setDiscussId(rs.getInt("discussId"));
				discuss.setArticleId(rs.getInt("articleId"));
				discuss.setName(rs.getString("name"));
				discuss.setEmail(rs.getString("email"));
				discuss.setContent(rs.getString("content"));
				discuss.setTime(rs.getString("time"));
				discussList.add(discuss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discussList;
	}
	/**
	 * @功能 查询某篇文章的评论内容
	 * @参数 id为String类型变量
	 * @返回值 discussList为List实例对象
	 */
	public List<DiscussBean> queryDiscussContent(String id){
		String sql="select * from discuss where articleId="+Integer.parseInt(id);
		List<DiscussBean> discussList=new ArrayList<DiscussBean>();
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				DiscussBean discuss=new DiscussBean();
				discuss.setDiscussId(rs.getInt("discussId"));
				discuss.setArticleId(rs.getInt("articleId"));
				discuss.setName(rs.getString("name"));
				discuss.setEmail(rs.getString("email"));
				discuss.setContent(rs.getString("content"));
				discuss.setTime(rs.getString("time"));
				discussList.add(discuss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discussList;
	}
	/**
	 * @功能 返回某文章的评论数
	 * @参数 文章id为String类型变量
	 * @返回值 int类型变量
	 */
	public int queryDiscussTimes(String id){
		int counts=0;
			String sql="select count(articleId)as count from discuss where articleId="+Integer.parseInt(id);
			ResultSet rs=commonADO.executeSelect(sql);
			try {
				if(rs.next()){
					counts=rs.getInt("count");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		return counts;
	}
	
	/**
	 * @功能 返回总评论数
	 * @参数 无
	 * @返回值 int类型变量
	 */
	public int queryAllDiscussTimes(){
		int counts=0;
			String sql="select count(*) as count from discuss";
			ResultSet rs=commonADO.executeSelect(sql);
			try {
				if(rs.next()){
					counts=rs.getInt("count");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		return counts;
	}
}
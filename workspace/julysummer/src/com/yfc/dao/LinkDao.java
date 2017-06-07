package com.yfc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yfc.toolBean.CommonADO;
import com.yfc.valueBean.LinkBean;

public class LinkDao {
	CommonADO commonADO;
	public LinkDao(){
		commonADO =CommonADO.getCommonADO();
	}
	
	/**
	 * @功能 查询所有链接
	 * @参数 无
	 * @返回 List 对象
	 */
	public List<LinkBean> queryLink(){
		String sql="select * from link";
		ResultSet rs=commonADO.executeSelect(sql);
		List<LinkBean> linkList=new ArrayList<LinkBean>();
		try {
			while(rs.next()){
				LinkBean lb=new LinkBean();
				lb.setLinkId(rs.getInt("linkId"));
				lb.setLinkLoveURL(rs.getString("linkLoveURL"));
				lb.setLinkName(rs.getString("linkLoveName"));
				linkList.add(lb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linkList;
	}
	
	/**
	 * @功能 删除链接
	 * @参数 String 类型 id
	 * @返回 boolean
	 */
	public boolean delteLink(String id){
		String sql="delete from link where linkId="+Integer.parseInt(id);
		return commonADO.executeUpdate(sql)>0;
	}
	/**
	 * @功能  添加链接
	 * @参数 LinkBean
	 * @返回 boolean 
	 */
	public boolean addLink(LinkBean single){
		String sql="insert into link(linkLoveURL,linkLoveName) values('"+single.getLinkLoveURL()+"','"+single.getLinkName()+"')";
		return commonADO.executeUpdate(sql)>0;
	}
	
	/**
	 * @功能 查询总数
	 * @参数 无
	 * @返回 int类型
	 */
	public int queryLinkAll(){
		String sql="select count(*) as allcount from link";
		ResultSet rs=commonADO.executeSelect(sql);
		int count=0;
		try {
			if(rs.next()){
				count=rs.getInt("allcount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}

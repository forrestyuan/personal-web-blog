package com.yfc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yfc.toolBean.CommonADO;
import com.yfc.valueBean.LeaveBean;

public class LeaveDao {
	private CommonADO commonADO;
	public LeaveDao(){
		commonADO=CommonADO.getCommonADO();
	}
	/**
	 * @功能 添加留言、删除留言
	 * @参数	oper为String类型变量  single为ArticleBean类型变量
	 * @返回值 boolean类型
	 */
	public boolean operationLeaveWord(String oper,LeaveBean single) {		
		/* 生成SQL语句 */
		String sql = null;
		oper=oper.toLowerCase().trim();
		if(oper.equals("add")){//添加留言
			sql = "insert into leave(name,email,topic,content,state,time) values('"+single.getName()+"','"+single.getEmail()+"','"+single.getTopic()+"','"+single.getContent()+"','"+single.getState()+"','"+single.getTime()+"')";
		}
		if(oper.equals("delete")){//删除留言
			sql = "delete from leave where leaveId="+single.getLeaveId();
		}
		/* 执行SQL语句 */	
		return commonADO.executeUpdate(sql)==1;
	}
	/**
	 * @功能 修改留言审核状态
	 * @参数 留言id为String 类型变量
	 * @返回值 boolean 类型变量
	 */
/*	public boolean checkLeaveState(String id){
		String sql = "update leave set state='yes' where leaveId="+Integer.parseInt(id);
		return commonADO.executeUpdate(sql)==1;
	}*/
	/**
	 * @功能 查看所有留言
	 * @返回值 list
	 */
	public List<LeaveBean> queryLeaveWord(){
		List<LeaveBean> list=new ArrayList<LeaveBean>();
		String sql="select * from leave";
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				LeaveBean lb=new LeaveBean();
				lb.setLeaveId(rs.getInt("leaveId"));
				lb.setName(rs.getString("name"));
				lb.setEmail(rs.getString("email"));
				lb.setTopic(rs.getString("topic"));
				lb.setContent(rs.getString("content"));
				lb.setState(rs.getString("state"));
				lb.setTime(rs.getString("time"));
				list.add(lb);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	/**
	 * @功能 返回指定留言数
	 * @返回值 List变量
	 */
	public List<LeaveBean> querySomeLeaveWord(int num){
		List<LeaveBean> list=new ArrayList<LeaveBean>();
		String sql="select top "+num+" * from leave order by leaveId desc";
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				LeaveBean lb=new LeaveBean();
				lb.setLeaveId(rs.getInt("leaveId"));
				lb.setName(rs.getString("name"));
				lb.setEmail(rs.getString("email"));
				lb.setTopic(rs.getString("topic"));
				lb.setContent(rs.getString("content"));
				lb.setState(rs.getString("state"));
				lb.setTime(rs.getString("time"));
				list.add(lb);
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	/**
	 * @功能 返回留言总数
	 * @返回值 int类型变量
	 */
	public int queryLeaveTimes(){
		String sql="select count(*) as times from leave";
		ResultSet rs=commonADO.executeSelect(sql);
		int counts=0;
		try {
			if(rs.next()){
				counts=rs.getInt("times");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counts;
	}
}

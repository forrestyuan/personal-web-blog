package com.yfc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yfc.toolBean.CommonADO;
import com.yfc.valueBean.PhotoBean;

public class LightDao {
	CommonADO commonADO=null;
	public LightDao(){
		commonADO=CommonADO.getCommonADO();
	}
	
	/**
	 * @功能 查询所有相片
	 * @返回 PhotoBean 的列表对象
	 */
	public List<PhotoBean> queryAllPic(){
		String sql="select * from photo";
		List<PhotoBean> pbList=new ArrayList<PhotoBean>();
		ResultSet rs=commonADO.executeSelect(sql);
		try {
			while(rs.next()){
				PhotoBean pb=new PhotoBean();
				pb.setPhotoId(rs.getInt("photoId"));
				pb.setName(rs.getString("name"));
				pb.setDescription(rs.getString("description"));
				pb.setSrc(rs.getString("src"));
				pbList.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pbList;
	}
	
	/**
	 * @功能 删除某张照片
	 * @参数 photoId 为String类型
	 * @返回 boolean
	 */
	public boolean deletePhoto(String id){
		String sql="delete from photo where photoId="+Integer.parseInt(id);
		int row=commonADO.executeUpdate(sql);
		return row>0?true:false;
	}
	
	/**
	 * @功能  添加照片
	 * @参数 PhotoBean类型对象
	 * @返回 boolean
	 */
	public boolean addPhoto(PhotoBean pb){
		String sql="insert into photo (name,description,src) values('"+pb.getName()+"','"+pb.getDescription()+"','"+pb.getSrc()+"')";
		int row=commonADO.executeUpdate(sql);
		return row>0?true:false;
	}
	/**
	 * @功能  统计图片总数
	 * @参数 无
	 * @返回 int型变量
	 */
	public int queryCountPic(){
		String sql="select count(*)as mypicall from photo";
		ResultSet rs=commonADO.executeSelect(sql);
		int allCount=0;
		try {
			if(rs.next()){
				allCount=rs.getInt("mypicall");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCount;
	}
}

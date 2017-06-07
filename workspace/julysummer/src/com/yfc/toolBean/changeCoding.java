package com.yfc.toolBean;

import java.io.UnsupportedEncodingException;
/**
 * @功能 将UTF-8转换为ISO8859-1
 * @参数 String类型变量
 */
public class changeCoding {
	public static String changeCode(String str){
		String strLater="";
		try {
			strLater=new String(str.getBytes("UTF-8"),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strLater;
	}
}

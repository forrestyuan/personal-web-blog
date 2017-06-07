package com.yfc.toolBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGet {
	public static String changeTime(Date date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);		
	}
}

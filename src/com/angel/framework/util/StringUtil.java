package com.angel.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

/**
 * 自定义
 * @author JBH
 */
public class StringUtil {

	/**
	 * 将str转换为20:30的时间格式
	 * @return
	 */
	public static String getStr(String str){
		
		String hour = "";
		String minute = "";
		if(isNull(str)){
			int len = str.length();
			if(len == 4){
				hour = str.substring(0, 2);
				minute = str.substring(2, str.length());
			}
		}
		return hour + ":" + minute;
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		
		if(str == null || "".equals(str)){
			
			return false;
		}
		return true;
	}
	
	/**
	 * 拼接成完整的时间格式
	 * @param date
	 * @param str
	 * @return
	 */
	public static String getDate(String date, String str){
		
		String datetime = date + " " + str + ":00";
		return datetime;
	}
	
	/**
	 * 计算时间间隔
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String diffBetween2Date(String beginDate, String endDate){
		
		String str = null;
		//时分为时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			
			//化为时间格式再进行计算
			Date _begin = sdf.parse(beginDate);
			Date _end = sdf.parse(endDate);
			if(_end.getHours() >= 0 && _begin.getHours() <24){
				_end.setHours(_end.getHours() + 24);
			}
			long distance = (_end.getTime() - _begin.getTime()) / 1000;
			long distance_hour = (distance / 3600) % 24;//计算小时间隔
			long distance_minute = (distance / 60) % 60;//计算分钟间隔
			str = distance_hour + "小时" + distance_minute + "分";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
		
	}
	
	
	/**
	 * json取参判断方法
	 * @param dataparam
	 * @param str
	 * @return
	 */
	public static boolean jsonString(JSONObject dataparam,String str){
		
		boolean msg = false;
		if(dataparam.containsKey(str) && dataparam.getString(str) != null && !"".equals(dataparam.getString(str)) && dataparam.getString(str) != "null"){
			msg = true;
		}
		return msg;
	}
}

package com.angel.framework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
	/**
	 * 得到现在的时间
	 * @param parttner
	 * @return
	 */
	public static String getNowString(String parttner){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(parttner);
		String now = sdf.format(c.getTime());
		return now;
		
	}

	/**
	 * Date转String
	 */
	public static String date2String2 (Date date){
		if(date==null){
			return "";
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
	}
	
	public static String date2String (Date date){
		if(date==null){
			return "";
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
	}
	
	public static String date2String (Date date,String pattern){
		if(date==null){
			return "";
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
	}
	
	/**
	 * 获取指定日期的第二天
	 * @param date
	 * @return
	 */
	public static Date nextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @param dateTime
	 * @return
	 */
	public static Date String2Date(String dateTime){
		Date date = null;
		try {
			if(dateTime==null || "".equals(dateTime))return null;
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date String2Date(String dateTime,String parttner){
		Date date = null;
		try {
			if(dateTime==null || "".equals(dateTime))return null;
			DateFormat df=new SimpleDateFormat(parttner);
			date = df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 得到今天的日期
	 * @param parttner自定义格式
	 * @return
	 */
	public static String getToday(String parttner){
		return getNowString(parttner);
		
	}
	/**
	 * 得到今天的日期，格式2011-12-01
	 * @param 
	 * @return
	 */
	public static String getToday(){
		return getToday("yyyy-MM-dd");
		
	}	
	/**
	 * 得到明天的日期
	 * @param parttner自定义格式
	 * @return
	 */
	public static String getTomorrow(String parttner){
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DATE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat(parttner);
		String tomorrow = sdf.format(c.getTime());
		return tomorrow;
		
	}
	/**
	 * 得到明天的日期，格式2011-12-01
	 * @param 
	 * @return
	 */
	public static String getTomorrow(){
		return getTomorrow("yyyy-MM-dd");
	}
	/**
	 * 指定时间的后天
	 */
	public static String getOneDayAfter(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
//		System.out.print(c.get(Calendar.YEAR)+","+c.get(Calendar.MONTH)+","+c.get(Calendar.DATE)+",");
		c.add(Calendar.DATE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tomorrow = sdf.format(c.getTime());
		return tomorrow;
	}
	
	/**
	 * 指定日期的下一个月
	 * @param date
	 * @return
	 */
	public static String getOneMonthAfter(Date date){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String afterMonth = sdf.format(cal.getTime());
		return afterMonth;
	}
	
	/**
	 * 相对于基准时间的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Long diffBetween2Day(Date date1,Date basisDate){
		long mi =date1.getTime() - basisDate.getTime();
		
		return mi/(1000*60*60*24);
	}
	
	
	/**
	 * 获取yyyy-MM-dd HH:mm:ss的标准时间
	 * @param date
	 * @return
	 * @author rudong
	 */
	public static String getDateLongString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 根据日期算出是星期几
	 * @param date
	 * @return
	 * @author chenwie
	 */
	public static String getWeekDay(int y,int m,int d){
		  String[] weeks=new String[]{"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		  GregorianCalendar gc=new GregorianCalendar();
		  gc.setLenient(false);
		  gc.set(y,m,d);
		  int week=gc.get(Calendar.DAY_OF_WEEK);
		  return new String(weeks[week-1]);
	}
	
	/**
	 * 根据指定日期获取星期几
	 * @return
	 */
	public static String getWeekDay(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		String weekDay = sdf.format(date);
		return weekDay;
	}
	
	/**
	 * 判断今天是周几
	 * chenweiqiang
	 * @return
	 */
	public static int dayForWeek() {
		Calendar c = Calendar.getInstance();
//		c.setTime(new DateUtil().String2Date(pTime, "yyyy-MM-dd"));
		c.setTime(new Date());
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	/**
	 * 时间加天数
	 * 
	 * @param time
	 * @param day
	 * @return
	 * @author Sun Zhaoli
	 */
	public static String addDateTime(String time, int day) {
		Date date = null;
		try {
			date = (new SimpleDateFormat("yyyy-MM-dd").parse(time));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		String newTime = new SimpleDateFormat("yyyy-MM-dd").format(cal
				.getTime());

		return newTime;
	}
	
	/**
	 * 判断某个周 周一到周日的日期
	 */
	public static Map<String,Object> getWeekByDay(String statisticsValue){
		Map<String,Object> data = new HashMap<String,Object>();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		System.out.println("此方法查询今天是周几,返回阿拉伯数字====" + dayForWeek);
		switch (dayForWeek) {
		case 1:
			data.put("startTime", statisticsValue);
			data.put("endTime",
					DateUtil.addDateTime(statisticsValue, 6));
			break;
		case 2:
			data.put("startTime",
					DateUtil.addDateTime(statisticsValue, -1));
			data.put("endTime",
					DateUtil.addDateTime(statisticsValue, 5));
			break;
		case 3:
			data.put("startTime",
					DateUtil.addDateTime(statisticsValue, -2));
			data.put("endTime",
					DateUtil.addDateTime(statisticsValue, 4));
			break;
		case 4:
			data.put("startTime",
					DateUtil.addDateTime(statisticsValue, -3));
			data.put("endTime",
					DateUtil.addDateTime(statisticsValue, 3));
			break;
		case 5:
			data.put("startTime",
					DateUtil.addDateTime(statisticsValue, -4));
			data.put("endTime",
					DateUtil.addDateTime(statisticsValue, 2));
			break;
		case 6:
			data.put("startTime",
					DateUtil.addDateTime(statisticsValue, -5));
			data.put("endTime",
					DateUtil.addDateTime(statisticsValue, 1));
			break;
		case 7:
			data.put("startTime",
					DateUtil.addDateTime(statisticsValue, -6));
			data.put("endTime", statisticsValue);
			break;
		}
		return data;
	}
}

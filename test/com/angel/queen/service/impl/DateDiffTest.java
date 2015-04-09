package com.angel.queen.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class DateDiffTest {

	@Test
	public void  TestDateDiff() throws ParseException{
		   SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   java.util.Date begin=dfs.parse("2004-03-10 11:30:24");
		   java.util.Date end = dfs.parse("2004-03-26 13:31:40");
		   long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
		   long day1=between/(24*3600);
		   long hour1=between%(24*3600)/3600;
		   long minute1=between%3600/60;
		   long second1=between%60/60;
		   if (day1==1) {
			System.out.println("昨天");
		   }
		   else if(day1==2){
			   System.out.println("前天");
		   }
		   else if (day1>2&&day1<=7) {
			System.out.println(day1+"天前");
		   }
		   else if (day1>7) {
			System.out.println(begin.toLocaleString());
		}
		   System.out.println(""+day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒");
	}
	
}

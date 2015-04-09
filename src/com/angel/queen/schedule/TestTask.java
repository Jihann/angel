package com.angel.queen.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * xml
 * @author JBH
 * @version 2015-02-10
 * @since JDK1.6
 */
public class TestTask {

	/** 日志记录 */
	private static Logger logger = Logger.getLogger(TestTask.class);
	
	/** 时间格式 */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/** 记录task次数 */
	int count = 1;
	
	/**
	 * 处理方法
	 */
	public void jobOne(){
		
		System.out.println("-------------------------数据正在清理中------------------------");
	}
	
	/**
	 * 每五分钟执行一次
	 */
	public void executeJobOne(){
		
		logger.info("-------------作用：test----------" + "时间：" + sdf.format(new Date()) + "----------次数：" + (count ++));
		this.jobOne();
	}
}

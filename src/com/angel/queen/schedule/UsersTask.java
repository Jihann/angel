package com.angel.queen.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.angel.queen.model.ConUsers;
import com.angel.queen.service.IConUsersService;

/**
 * annotation
 * @author JBH
 * @version 2015-02-10
 * @since JDK1.6
 */
@Component
public class UsersTask {

	/** 日志记录 */
	private static Logger logger = Logger.getLogger(UsersTask.class);
	
	/** 时间格式 */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/** 记录task次数 */
	int count = 1;
	
	/** service */
	@Autowired
	private IConUsersService conUsersServiceImpl;
	
	/**
	 * 处理方法
	 */
	public void doWithUsers(){
		
		String username = "admin";
		ConUsers exist = this.conUsersServiceImpl.findUserByUserName(username);
		if(exist != null){
			logger.info("--------------数据安全-----------------");
		}else{
			logger.info("--------------数据不安全--------------");
		}
	}
	
	/**
	 * 每五分钟执行一次
	 */
	//@Scheduled(cron = "0 0/5 * * * ?")
	public void executeJobOne(){
		
		logger.info("-------------作用：数据安全核对中----------" + "时间：" + sdf.format(new Date()) + "----------次数：" + (count ++));
		this.doWithUsers();
	}
}

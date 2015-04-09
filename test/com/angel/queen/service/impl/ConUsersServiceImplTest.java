package com.angel.queen.service.impl;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.angel.queen.base.BaseDAOTestCaseJunit4;
import com.angel.queen.model.ConUsers;
import com.angel.queen.service.IConUsersService;

public class ConUsersServiceImplTest extends BaseDAOTestCaseJunit4{
				
	private static Logger logger = Logger.getLogger(ConUsersServiceImplTest.class);
	
	@Autowired
	private IConUsersService conUsersServiceImpl;
	
	@Test
	public void testLogin() {
		
		logger.info("------------------test---------------");
		
		ConUsers user = new ConUsers();
		user.setUserName("admin");
		user.setPassword("123456");
		ConUsers loginUser = this.conUsersServiceImpl.login(user);
		
		Assert.assertNotNull(loginUser);
	}

}

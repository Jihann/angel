package com.angel.queen.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angel.queen.dao.mapper.ConUsersMapper;
import com.angel.queen.model.ConUsers;
import com.angel.queen.service.IConUsersService;

/**
 * 类名称：
 * 类描述：
 * @author JBH
 * @version 2015-01-26
 * @since JDK1.6
 */
@Service
public class ConUsersServiceImpl  implements IConUsersService{

	/** 日志记录 */
	private final Logger logger = Logger.getLogger(ConUsersServiceImpl.class);
	
	/** 对应用户数据访问层  */
	@Autowired
	private ConUsersMapper conUsersMapper;
	
	public ConUsers login(ConUsers user) {
		
		logger.info("------------------user login service-------------");
		return this.conUsersMapper.userLogin(user);
	}

	public ConUsers findUserByUserName(String userName) {
		return this.conUsersMapper.selectUserByUserName(userName);
	}

	@Transactional
	public int createUser(ConUsers user) throws Exception{
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			logger.info("-------------此步发生异常-----------" + e);
			//让spring管理实务回滚dao操作，
			//throw new BizException("用户注册失败");
		}
		return this.conUsersMapper.insert(user);
	}

	/**
	 * 缓存处理
	 */
	//@Cacheable(cacheName = "30minCache")
	public List<ConUsers> list() {
		
		System.out.println("-----------------list--------------------");
		return this.conUsersMapper.list();
	}

	@Transactional
	public int deleteUser(Long userId) throws Exception {
		return this.conUsersMapper.deleteByPrimaryKey(userId);
	}

	@Transactional
	public int updateState(ConUsers user) throws Exception {
		return this.conUsersMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public ConUsers findUserByUserId(Long userId) {
		return this.conUsersMapper.selectByPrimaryKey(userId);
	}
}

package com.angel.queen.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.queen.dao.mapper.SysCmsLinkMapper;
import com.angel.queen.model.SysCmsLink;
import com.angel.queen.service.ISysCmsLinkService;

@Service
public class SysCmsLinkServiceImpl 
				implements ISysCmsLinkService{

	/** 日志记录 */
	private final Logger logger = Logger.getLogger(SysCmsLinkServiceImpl.class);
	
	/** 对应用户数据访问层  */
	@Autowired
	private SysCmsLinkMapper sysCmsLinkMapper;
	
	@Override
	public List<SysCmsLink> list() {
		logger.info("------------------list--------------");
		return this.sysCmsLinkMapper.list();
	}

}

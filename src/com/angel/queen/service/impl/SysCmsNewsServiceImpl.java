package com.angel.queen.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angel.queen.dao.mapper.SysCmsNewsMapper;
import com.angel.queen.model.SysCmsNews;
import com.angel.queen.service.ISysCmsNewsService;

@Service
public class SysCmsNewsServiceImpl 
				implements ISysCmsNewsService{

	private static Logger logger = Logger.getLogger(SysCmsNewsServiceImpl.class);
	
	@Autowired
	private SysCmsNewsMapper sysCmsNewsMapper;
	
	@Override
	public int addNews(SysCmsNews sysCmsNews) {
		logger.info("-------------service add news --------------");
		return this.sysCmsNewsMapper.insert(sysCmsNews);
	}

	@Override
	public List<SysCmsNews> queryCmsList() {
		return this.sysCmsNewsMapper.queryCmsList();
	}

}

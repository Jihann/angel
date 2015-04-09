package com.angel.queen.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angel.queen.model.SysCmsNews;
import com.angel.queen.service.ISysCmsNewsService;

@Controller
@RequestMapping("/news")
public class SysCmsNewsController {

	private static Logger logger = Logger.getLogger(SysCmsNewsController.class);
	
	@Autowired
	private ISysCmsNewsService sysCmsNewsServiceImpl;
	
	@RequestMapping("/list")
	public @ResponseBody List<SysCmsNews> list(){
		
		List<SysCmsNews> list = this.sysCmsNewsServiceImpl.queryCmsList();
		logger.info("----------------news length---------------" + list.size());
		
		return list;
	}
}

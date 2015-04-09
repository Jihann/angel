package com.angel.queen.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angel.queen.model.SysCmsLink;
import com.angel.queen.service.ISysCmsLinkService;

@Controller
@RequestMapping("/link")
public class SysCmsLinkController {

	private final Logger logger = Logger.getLogger(SysCmsLinkController.class);
	
	@Autowired
	private ISysCmsLinkService sysCmsLinkServiceImpl;
	
	@RequestMapping("/list")
	public @ResponseBody List<SysCmsLink> show(){
		
		List<SysCmsLink> list = this.sysCmsLinkServiceImpl.list();
		logger.info("---------------总共有" + list.size() + "条友情链接---------------");
		return list;
	}
}

package com.angel.queen.controller.backend;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.angel.queen.model.SysCmsNews;
import com.angel.queen.service.ISysCmsNewsService;

@Controller
@RequestMapping("/back/news")
public class BackSysCmsNewsController {

	private static Logger logger = Logger.getLogger(BackSysCmsNewsController.class);
	
	@Autowired
	private ISysCmsNewsService sysCmsNewsServiceImpl;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createNews(){
		
		return "backend/news/news_create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNews(SysCmsNews sysCmsNews, Model model){
		
		sysCmsNews.setCreateTime(new Date());
		int result = this.sysCmsNewsServiceImpl.addNews(sysCmsNews);
		if(result == 1){
			logger.info("-----------create news success-----------------");
		}else{
			logger.info("-----------creaet news failure-----------------");
		}
		return "redirect:/back/news/list";
	}
	
	@RequestMapping("/list")
	public String list(){
		
		return "backend/news/news_list";
	}
}

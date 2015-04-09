package com.angel.queen.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angel.framework.common.Page;
import com.angel.queen.common.BaseController;
import com.angel.queen.controller.param.ArticleForm;
import com.angel.queen.service.IArticleManageService;

@Controller
@RequestMapping("/articleManage")
public class ArticleManageController extends BaseController {
    
	@Resource
	IArticleManageService articleManageService;
	
	@RequestMapping("/list")
	public String queryArticleList(Page page,Model model,ArticleForm articleForm){
		page.setQueryParam(articleForm);
	    model.addAttribute("articles",articleManageService.queryArticleList(page));
		return "oyzBBS";
	}
}

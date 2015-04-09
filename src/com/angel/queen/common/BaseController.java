package com.angel.queen.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	/** HttpServletRequest */
	protected HttpServletRequest request;
	
	/** HttpServletResponse */
	protected HttpServletResponse response;
	
	/** HttpSession */
	protected HttpSession session;
	
	/**
	 * 将一些准备数据的操作放置在该方法里面
	 * 进行初始化准备
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void setBaseController(HttpServletRequest request, HttpServletResponse response){
		
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}
}

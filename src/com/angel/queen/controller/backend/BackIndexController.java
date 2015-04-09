package com.angel.queen.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class BackIndexController {

	@RequestMapping(value="/index")
	public String index(){
		return "backend/index";
	}
	
}

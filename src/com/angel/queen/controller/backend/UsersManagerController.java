package com.angel.queen.controller.backend;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angel.queen.model.ConUsers;
import com.angel.queen.service.IConUsersService;

@Controller
@RequestMapping("/back/users")
public class UsersManagerController {

	/** 日志实例 */
	private static Logger logger = Logger.getLogger(UsersManagerController.class);
	
	/** service */
	@Autowired
	private IConUsersService conUsersServiceImpl;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model){
		
		List<ConUsers> userList = this.conUsersServiceImpl.list();
		logger.info("--------------总共有用户：" + userList.size() + "--------------条");
		model.addAttribute("userList", userList);
		return "backend/users/users_list";
	}
	
	/**
	 * 彻底测试restful
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{userId}/person", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable Long userId){
		
		int result = 0;
		try {
			result = this.conUsersServiceImpl.deleteUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String remark = (result == 1) ? "success" : "failure";
		logger.info("------------delete result-----------" + remark + "----------");
		return remark;
	}
	
	@RequestMapping(value = "/{userId}/{state}/person", method = RequestMethod.PUT)
	public @ResponseBody String updateState(@PathVariable Long userId, @PathVariable String state){
		
		int result = 0;
		ConUsers user = this.conUsersServiceImpl.findUserByUserId(userId);
		if(user != null){
			user.setLastLoginIp(state);
		}
		try {
			result = this.conUsersServiceImpl.updateState(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String remark = (result == 1) ? "success" : "failure";
		logger.info("------------delete result-----------" + remark + "----------");
		return remark;
	}
}

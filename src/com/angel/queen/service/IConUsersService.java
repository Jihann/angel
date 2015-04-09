package com.angel.queen.service;

import java.util.List;

import com.angel.queen.model.ConUsers;

public interface IConUsersService {

	public ConUsers login(ConUsers user);
	
	public ConUsers findUserByUserName(String userName);
	
	public int createUser(ConUsers user) throws Exception;
	
	public List<ConUsers> list();
	
	public int deleteUser(Long userId) throws Exception;
	
	public int updateState(ConUsers user) throws Exception;
	
	public ConUsers findUserByUserId(Long userId);
}

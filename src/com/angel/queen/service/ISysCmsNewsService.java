package com.angel.queen.service;

import java.util.List;

import com.angel.queen.model.SysCmsNews;

public interface ISysCmsNewsService {

	public int addNews(SysCmsNews sysCmsNews);
	
	public List<SysCmsNews> queryCmsList();
}

package com.angel.queen.service;


import com.angel.framework.common.Page;
import java.util.List;

import org.springframework.ui.Model;

import com.angel.queen.model.ArticleModel;
import com.angel.queen.model.ArticleModelReply;



public interface IArticleManageService  {

	List<ArticleModelReply> queryArticleList(Page page);
}

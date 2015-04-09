package com.angel.queen.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.angel.framework.common.Page;
import com.angel.queen.dao.mapper.ArticleModelMapper;
import com.angel.queen.model.ArticleModel;
import com.angel.queen.model.ArticleModelReply;
import com.angel.queen.service.IArticleManageService;

@Service
public class ArticleManageServiceImpl implements IArticleManageService {

	/** 日志记录 */
	private final Logger logger = Logger
			.getLogger(ArticleManageServiceImpl.class);

	@Autowired
	ArticleModelMapper articleModelMapper;

	@Override
	public List<ArticleModelReply> queryArticleList(Page page) {
		List<ArticleModel> articleModels = articleModelMapper
				.queryArticleList(page);
		List<ArticleModelReply> articleModelReplys = new ArrayList();
		for (ArticleModel model : articleModels) {
			ArticleModelReply modelReply = parseArticleModel(model);
			articleModelReplys.add(modelReply);
		}
		return articleModelReplys;
	}

	// 解析帖子的条件
	private ArticleModelReply parseArticleModel(ArticleModel articleModel){
		ArticleModelReply modelReply = new ArticleModelReply();
		modelReply.setAuthor(articleModel.getAuthor());
		modelReply.setLastReplyer("jack");
		modelReply.setTitle(articleModel.getArticletitle());
		try {
			modelReply.setPublishDateDescribe(CovertSendToLocalDate(articleModel.getPublishtime()));
			modelReply.setLastReplyDateDesribe(CovertSendToLocalDate(articleModel.getPublishtime())); //要修改一下才行
		} catch (ParseException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return modelReply;
	}

	// 转换到通俗的时间
	@SuppressWarnings("deprecation")
	private String CovertSendToLocalDate(String date) throws ParseException {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date begin = dfs.parse(date);
		java.util.Date end = new Date();
		int mouthDiff = end.getMonth() - begin.getMonth();
		int day1 = end.getDay() - begin.getDay();
		
		//具体时间
		SimpleDateFormat timeDate= new SimpleDateFormat("HH:mm");
		String MinitesDescribe = timeDate.format(begin);
		if (mouthDiff==0) {
			if (day1 == 0) {
				return "今天 "+MinitesDescribe;
			} else if (day1 == 1) {
				return "昨天 "+MinitesDescribe;
			} else if (day1 == 2) {
				return "前天 "+MinitesDescribe;
			} else if (day1 > 2 && day1 <= 7) {
				return day1 + "天前 "+MinitesDescribe;
			}else {
				return date;
			}
		}
		else {
			return date;
		}
	}

	// 转换到通俗的时间
	private String CovertFollowerToLocalDate(String date) throws ParseException {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date begin = dfs.parse(date);
		java.util.Date end = new Date();
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		long day1 = between / (24 * 3600);
		long hour1 = between % (24 * 3600) / 3600;
		long minute1 = between % 3600 / 60;
		long second1 = between % 60 / 60;
		
		SimpleDateFormat timeDate= new SimpleDateFormat("HH:mm");
		String MinitesDescribe = timeDate.format(begin);
		if (day1 == 0) {
			return "今天 "+MinitesDescribe;
		} else if (day1 == 1) {
			return "昨天 "+MinitesDescribe;
		} else if (day1 == 2) {
			return "前天 "+MinitesDescribe;
		} else if (day1 > 2 && day1 <= 7) {
			return day1 + "天前 "+MinitesDescribe;
		} else {
			return dfDate.format(date)+" "+MinitesDescribe;
		}
	}
}

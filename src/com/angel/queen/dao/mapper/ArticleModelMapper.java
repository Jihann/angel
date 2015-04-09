package com.angel.queen.dao.mapper;

import java.util.List;

import com.angel.framework.common.Page;
import com.angel.queen.dao.SqlMapper;
import com.angel.queen.model.ArticleModel;

public interface ArticleModelMapper extends SqlMapper {
    int deleteByPrimaryKey(Integer articleid);

    int insert(ArticleModel record);

    int insertSelective(ArticleModel record);

    ArticleModel selectByPrimaryKey(Integer articleid);

    int updateByPrimaryKeySelective(ArticleModel record);

    int updateByPrimaryKey(ArticleModel record);
    
    List<ArticleModel> queryArticleList(Page page);
}
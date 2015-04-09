package com.angel.queen.dao.mapper;

import java.util.List;

import com.angel.queen.dao.SqlMapper;
import com.angel.queen.model.SysCmsNews;

public interface SysCmsNewsMapper 
						extends SqlMapper{
	
    int deleteByPrimaryKey(Integer id);

    int insert(SysCmsNews record);

    int insertSelective(SysCmsNews record);

    SysCmsNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCmsNews record);

    int updateByPrimaryKeyWithBLOBs(SysCmsNews record);

    int updateByPrimaryKey(SysCmsNews record);
    
    List<SysCmsNews> queryCmsList();
}
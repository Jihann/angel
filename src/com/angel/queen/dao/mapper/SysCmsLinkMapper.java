package com.angel.queen.dao.mapper;

import java.util.List;

import com.angel.queen.dao.SqlMapper;
import com.angel.queen.model.SysCmsLink;

public interface SysCmsLinkMapper 
						extends SqlMapper{
	
    int deleteByPrimaryKey(Integer id);

    int insert(SysCmsLink record);

    int insertSelective(SysCmsLink record);

    SysCmsLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCmsLink record);

    int updateByPrimaryKey(SysCmsLink record);
    
    List<SysCmsLink> list();
}
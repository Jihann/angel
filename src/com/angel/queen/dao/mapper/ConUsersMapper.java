package com.angel.queen.dao.mapper;

import java.util.List;

import com.angel.queen.dao.SqlMapper;
import com.angel.queen.model.ConUsers;

/**
 * 类名称：
 * 类描述：
 * @author Jihann
 * @version 2015-01-26
 * @since JDK1.6
 */
public interface ConUsersMapper 
					extends SqlMapper{
    int deleteByPrimaryKey(Long userId);

    int insert(ConUsers record);

    int insertSelective(ConUsers record);

    ConUsers selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(ConUsers record);

    int updateByPrimaryKey(ConUsers record);
    
    ConUsers userLogin(ConUsers user);
    
    ConUsers selectUserByUserName(String userName);
    
    List<ConUsers> list();
}

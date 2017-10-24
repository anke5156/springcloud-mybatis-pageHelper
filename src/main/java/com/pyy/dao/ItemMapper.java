package com.pyy.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pyy.pojo.Item;



public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);
    
    List<Item> selectAll();
    
    List<Item> selectByParams(Map<String,Object> params);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}
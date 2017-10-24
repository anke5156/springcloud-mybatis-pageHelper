package com.pyy.service;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pyy.dao.ItemMapper;
import com.pyy.pojo.Item;

@Service("itemService")
public class ItemService {
	private static final Logger log = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> selectAll(){
		return itemMapper.selectAll();
	}
	
	
	public List<Item> selectByParams(Map<String,Object> params){
		return itemMapper.selectByParams(params);
	}
	
	/**
	 * 分页查询
	 * @param currentPage 当前页
	 * @param pageSize    分页尺寸
	 * @return
	 */
	public List<Item> selectAllAndPage(int currentPage, int pageSize){
		// 设置分页
		Page<Item> page = PageHelper.startPage(currentPage, pageSize);
		List<Item> itemList = itemMapper.selectAll();
		log.info("分页对象信息:{}",page);
		
		return itemList;
	}
	
	/**
	 * 多条件分页查询
	 * @param params
	 * @param currentPage 当前页
	 * @param pageSize    分页尺寸
	 * @return
	 */
	public List<Item> selectByParamsAndPage(Map<String,Object> params, int currentPage, int pageSize){
		// 设置分页
		Page<Item> page = PageHelper.startPage(currentPage, pageSize);
		
		List<Item> itemList = itemMapper.selectByParams(params);
		log.info("分页对象信息:{}",page);
		return itemList;
	}
}

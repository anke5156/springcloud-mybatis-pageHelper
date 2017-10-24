package com.pyy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.pyy.pojo.Item;
import com.pyy.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "ItemController", description = "商品信息Controller")
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@ApiOperation(value="查询所有信息", notes="查询所有信息（带分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页尺寸", required = false, dataType = "int", paramType = "query")
    })
	@GetMapping(value = "/findAllAndPage", produces="application/json;charset=UTF-8")
	public List<Item> findAllAndPage(@RequestParam(value = "currentPage", defaultValue = "1" )int currentPage, @RequestParam(value = "pageSize", defaultValue = "10" )int pageSize){
		return itemService.selectAllAndPage(currentPage, pageSize);
	}
	
	@ApiOperation(value="多条件模糊查询（带分页）", notes="多条件模糊查询（带分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页尺寸", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "price", value = "价格", required = false, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "updated", value = "修改时间", required = false, dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "created", value = "创建时间", required = false, dataType = "Date", paramType = "query")
    })
	@GetMapping(value = "/findAllAndPageByParams", produces="application/json;charset=UTF-8")
	public List<Item> findAllAndPageByParams(
			@RequestParam(value = "currentPage", defaultValue = "1" , required = false)int currentPage, 
			@RequestParam(value = "pageSize", defaultValue = "10" , required = false)int pageSize,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "price", required = false) Long price,
			@RequestParam(value = "updated", required = false) String updated,
			@RequestParam(value = "created", required = false) String created){
		
		Map<String, Object> params = Maps.newHashMap();
		params.put("title", title);
		
		System.out.println(title+"=============================");
		params.put("price", price);
		try {
			if(StringUtils.isNotBlank(updated)){
				params.put("updated", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(updated));
			}
			
			if(StringUtils.isNotBlank(created)){
				params.put("created", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(created));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return itemService.selectByParamsAndPage(params, currentPage, pageSize);
	}
}

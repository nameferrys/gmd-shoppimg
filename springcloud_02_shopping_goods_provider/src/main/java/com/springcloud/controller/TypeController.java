package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;
import com.springcloud.service.TypeService;
import com.springcloud.vo.ResultValue;

/**
 * 一级类别与二级类别的控制器
 * @author ferry
 *
 */
@RestController
@RequestMapping("type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * 查询所有一级类别信息
	 * @return
	 */
	@RequestMapping(value = "/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		try {
			//调用service中的相应的方法查询所有一级类别的信息，并获得查询结果NullPointerExcetion
			List<TypeOne> selectAllTypeOne = this.typeService.selectAllTypeOne();
			//如果成功
			if(selectAllTypeOne != null && selectAllTypeOne.size() > 0) {
				//设置结果的状态为0
				rv.setCode(0);
				//创建Map集合保存查询结果
				Map<String, Object> map = new HashMap<>();
				//将查询结果保存到Map集合中
				map.put("selectAllTypeOne", selectAllTypeOne);
				//将map集合添加到ResultValue对象中
				rv.setDataMap(map);
				//返回ResultValue对象
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	/**
	 * 根据一级类别查询相应二级类别的信息
	 * @param typeOneId  一级类别编号
	 * @return
	 */
	@RequestMapping(value = "/selectById")
	public ResultValue selectById(@RequestParam("typeOneId") Integer typeOneId) {
		ResultValue rv = new ResultValue();
		try {
			//调用service中的相应的方法查询所有二级类别的信息，并获得查询结果
			List<TypeTwo> selectTypeTwoTypeOneId = this.typeService.selectTypeTwoTypeOneId(typeOneId);
			//如果成功
			if(selectTypeTwoTypeOneId != null && selectTypeTwoTypeOneId.size() > 0) {
				//设置结果的状态为0
				rv.setCode(0);
				//创建Map集合保存查询结果
				Map<String, Object> map = new HashMap<>();
				//将查询结果保存到Map集合中
				map.put("selectTypeTwoTypeOneId", selectTypeTwoTypeOneId);
				//将map集合添加到ResultValue对象中
				rv.setDataMap(map);
				//返回ResultValue对象
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
}

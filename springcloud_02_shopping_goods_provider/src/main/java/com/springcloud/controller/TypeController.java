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
 * һ�������������Ŀ�����
 * @author ferry
 *
 */
@RestController
@RequestMapping("type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * ��ѯ����һ�������Ϣ
	 * @return
	 */
	@RequestMapping(value = "/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();
		try {
			//����service�е���Ӧ�ķ�����ѯ����һ��������Ϣ������ò�ѯ���NullPointerExcetion
			List<TypeOne> selectAllTypeOne = this.typeService.selectAllTypeOne();
			//����ɹ�
			if(selectAllTypeOne != null && selectAllTypeOne.size() > 0) {
				//���ý����״̬Ϊ0
				rv.setCode(0);
				//����Map���ϱ����ѯ���
				Map<String, Object> map = new HashMap<>();
				//����ѯ������浽Map������
				map.put("selectAllTypeOne", selectAllTypeOne);
				//��map������ӵ�ResultValue������
				rv.setDataMap(map);
				//����ResultValue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	/**
	 * ����һ������ѯ��Ӧ����������Ϣ
	 * @param typeOneId  һ�������
	 * @return
	 */
	@RequestMapping(value = "/selectById")
	public ResultValue selectById(@RequestParam("typeOneId") Integer typeOneId) {
		ResultValue rv = new ResultValue();
		try {
			//����service�е���Ӧ�ķ�����ѯ���ж���������Ϣ������ò�ѯ���
			List<TypeTwo> selectTypeTwoTypeOneId = this.typeService.selectTypeTwoTypeOneId(typeOneId);
			//����ɹ�
			if(selectTypeTwoTypeOneId != null && selectTypeTwoTypeOneId.size() > 0) {
				//���ý����״̬Ϊ0
				rv.setCode(0);
				//����Map���ϱ����ѯ���
				Map<String, Object> map = new HashMap<>();
				//����ѯ������浽Map������
				map.put("selectTypeTwoTypeOneId", selectTypeTwoTypeOneId);
				//��map������ӵ�ResultValue������
				rv.setDataMap(map);
				//����ResultValue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
}

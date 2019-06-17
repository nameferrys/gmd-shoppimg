package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;

/**
 * ���ڶ���һ�������������ģ��ķ���
 * 
 * @author ferry
 *
 */
public interface TypeService {

	/**
	 * ��ѯһ��������Ϣ
	 * 
	 * @return �ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	public abstract List<TypeOne> selectAllTypeOne();

	/**
	 * ����һ������Ų�ѯ��Ӧ�Ķ��������Ϣ
	 * 
	 * @param typeOneId һ�����ı��
	 * @return �ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	public abstract List<TypeTwo> selectTypeTwoTypeOneId(Integer typeOneId);
	
	
	
}

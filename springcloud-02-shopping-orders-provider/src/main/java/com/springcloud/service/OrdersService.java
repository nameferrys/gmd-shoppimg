package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Orders;

/**
 * 
 * ����ģ��ģ�Ͳ�Ľӿڣ����ڶ��嶩��ģ�͵ķ���
 * 
 * @author ferry
 *
 */
public interface OrdersService {

	/**
	 * ��ѯ���������Ķ�����Ϣ����ҳ���ܣ�
	 * 
	 * @param orders     ��ѯ����
	 * @param pageNumber ��ҳ��Ϣ
	 * @return ����com.github.pagehelper.PageInfo���͵�ʵ��
	 */
	public abstract PageInfo<Orders> selectOrders(Orders orders, Integer pageNumber);

	/**
	 * �޸�orders����ָ��order_Id�Ķ���״̬
	 * 
	 * @param orders �޸Ķ���״̬
	 * @return �ɹ����ش���0��������ʧ�ܷ���0
	 */
	public abstract Integer updateOrdersStatus(Orders orders);
	
	/**
	 * ��ѯָ�����ڷ�Χ�ڵ����۶�
	 * 
	 * @param orders ��ѯ����
	 * @return �ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	public abstract List<Orders> selectGroup(Orders orders);
}

package com.springcloud.service;

import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

/**
 * ģ�Ͳ�ӿڣ����ڶ����û�ģ��ķ���
 * 
 * @author ferry
 *
 */
public interface UserService {

	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * 
	 * @param userId           �û����
	 * @param userPsw�û�����
	 * @param permissionIdȨ�ޱ��
	 * @return �ɹ����ص�¼�û���������Ϣ��ʧ�ܷ���null
	 */
	public abstract Users login(Integer userId, String userPsw, Integer permissionId);

	/**
	 * ����µ��û���Ϣ
	 * 
	 * @param users �µ��û���Ϣ
	 * @return ��ӳɹ�����com.spring.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users insert(Users users);

	/**
	 * ��ѯ�����������û���Ϣ
	 * 
	 * @param users      ��ѯ����
	 * @param pageNumber ��ѯҳ��
	 * @return �ɹ�����org.springframework.data.domain.Page���͵�ʵ��
	 */
	public abstract Page<Users> select(Users users, Integer pageNumber);

	/**
	 * �޸�USERS���е�ָ����ŵ��û�״̬
	 * 
	 * @param userId     �û����
	 * @param userStatus �û�״̬
	 * @return �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateStatus(Integer userId, Integer userStatus);

	/**
	 * ��ѯָ����ŵ��û���Ϣ
	 * 
	 * @param userId �û����
	 * @return �ɹ�����com.springcloud.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users selectById(Integer userId);

	/**
	 * �޸�ָ����ŵ���Ϣ
	 * 
	 * @param users �û���Ϣ
	 * @return �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer update(Users users);
	
	
	
	/**
	 * ���ݲ����޸�ָ���û�����û������û��ǳ�
	 * @param users �޸��û���Ϣ
	 * @return �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateMessage(Users users);
}

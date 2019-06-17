package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * type_two ���Ӧ��ʵ���࣬���ڱ������һ�ж��������Ϣ
 * 
 * @author ferry
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTwo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9117495822231456760L;

	/**
	 * ���Ͷ����
	 */
	private Integer typeTwoId;

	/**
	 * ���Ͷ�����
	 */
	private String typeTwoName;

	/**
	 * ����һ���
	 */
	private Integer typeOneId;

	/**
	 * ��ע
	 */
	private String typeTwoRemark;

}
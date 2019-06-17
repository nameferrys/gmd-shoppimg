package com.springcloud.vo;

import java.util.Map;

import lombok.Data;

/**
 * ���屾��Ŀ������controller���صĽ������
 * @author ferry
 *
 */
@Data
public class ResultValue implements java.io.Serializable {

	
	private static final long serialVersionUID = 6983873178143794112L;
	/**
	 * ���õ�ǰ���ؽ����״̬��0��ʾ�ɹ���1��ʾʧ��
	 */
	private Integer code;
	
	/**
	 * ���÷��ص���Ϣ
	 */
	private String message;

	/**
	 * ���÷��ص�����
	 */
	private Map<String,Object> dataMap;
	
	
}

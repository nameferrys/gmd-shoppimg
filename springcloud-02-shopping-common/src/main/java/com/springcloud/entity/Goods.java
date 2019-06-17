package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * goods ����Ӧ��ʵ���࣬���ڷ�װһ����Ʒ��Ϣ
 * 
 * @author ferry
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3427056522676684614L;

	/**
	 * ��Ʒ���
	 */
	private Integer goodsId;

	/**
	 * ��Ʒ����
	 */
	private String goodsName;

	/**
	 * ��Ʒ�۸�
	 */
	private Double goodsPrice;

	/**
	 * ��Ʒ�ۿۼ�
	 */
	private Double goodsDiscount;

	/**
	 * ��Ʒ״̬
	 */
	private Integer goodsStatus;

	/**
	 * ��Ʒ����
	 */
	private Integer goodsNum;

	/**
	 * �Ƿ���Ʒ
	 */
	private Integer goodsNew;

	/**
	 * �Ƿ�����
	 */
	private Integer goodsHot;

	/**
	 * ��Ʒ����
	 */
	private Integer goodsLevel;

	/**
	 * ��Ʒ���
	 */
	private String goodsDesc;

	/**
	 * ��Ʒ����
	 */
	private String goodsDetail;

	/**
	 * ��ƷͼƬ
	 */
	private String goodsImg;

	/**
	 * ���Ͷ����
	 */
	private Integer typeTwoId;

	/**
	 * ��ѯ����:��Ʒ�۸������
	 */
	private Double goodsPriceMin;

	/**
	 * ��ѯ����:��Ʒ�۸������
	 */
	private Double goodsPriceMax;

	/**
	 * ��ѯ������һ�����ͱ��
	 */
	private Integer typeOneId;
	
	/**
	 *��Ʒ���� �����ڱ���ͳ�Ʒ���Ľ��
	 */
	private Integer goodsSum;

}
package com.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.repository.UserRepository;
import com.springcloud.service.UserService;

/**
 * ģ�Ͳ��ʵ���࣬ʵ���û�ģ��ķ���
 * @author ferry
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Users login(Integer userId, String userPsw, Integer permissionId) {
		return this.userRepository.login(userId, userPsw, permissionId);
	}


	@Transactional  //��ʾ�������֧������
	@Override
	public Users insert(Users users) {
		return this.userRepository.save(users);
	}


	@Override
	public Page<Users> select(Users users, Integer pageNumber) {
		//���ݲ�ѯ�����ݣ�������̬����
		@SuppressWarnings("serial")
		//���������ಿ��
		Specification<Users> specification = new Specification<Users>() {
			
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//����һ��List���ϣ����ڱ������е�where����
				List<Predicate> whereList = new ArrayList<>();
				
				//����users�еĲ�ѯ���ݣ���̬������ѯ����
				if(users.getUserName() != null && !users.getUserName().trim().equals("")) {
					whereList.add(criteriaBuilder.like(root.get("userName"), "%" + users.getUserName() + "%"));
				}
				if(users.getUserStatus() != -1) {
					whereList.add(criteriaBuilder.equal(root.get("userStatus"), users.getUserStatus()));
				}
				//��ʹ�õ�������and��ϵ��ϵ��һ�𲢷���
				return criteriaBuilder.and(whereList.toArray(new Predicate[whereList.size()]));
			}
		};
		//����jpa�ķ�ҳ��Ϣ
		PageRequest of = PageRequest.of(pageNumber, PageUtils.PAGE_ROW_COUNT);
		
		return this.userRepository.findAll(specification, of);
	}


	@Transactional
	@Override
	public Integer updateStatus(Integer userId, Integer userStatus) {
		return this.userRepository.updateStatus(userId, userStatus);
	}


	@Override
	public Users selectById(Integer userId) {
		return this.userRepository.findById(userId).get();
	}

	@Transactional
	@Override
	public Integer update(Users users) {
		return this.userRepository.update(users);
	}


	@Transactional
	@Override
	public Integer updateMessage(Users users) {
		if(users.getUserImage() != null && !users.getUserImage().equals("")) {
			return this.userRepository.updateImage(users);
		}else if(users.getUserPsw() != null && !users.getUserPsw().equals("")) {
			return this.userRepository.updatePsw(users);
		}else if(users.getUserName() != null && !users.getUserName().equals("")) {
			return this.userRepository.updateName(users);
		}
		return 0;
	}

}

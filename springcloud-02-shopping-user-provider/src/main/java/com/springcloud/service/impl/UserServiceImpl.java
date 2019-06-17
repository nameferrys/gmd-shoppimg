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
 * 模型层的实现类，实现用户模块的方法
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


	@Transactional  //表示这个方法支持事务
	@Override
	public Users insert(Users users) {
		return this.userRepository.save(users);
	}


	@Override
	public Page<Users> select(Users users, Integer pageNumber) {
		//根据查询的数据，创建动态条件
		@SuppressWarnings("serial")
		//创建匿名类部类
		Specification<Users> specification = new Specification<Users>() {
			
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//创建一个List集合，用于保存所有的where条件
				List<Predicate> whereList = new ArrayList<>();
				
				//根据users中的查询数据，动态创建查询条件
				if(users.getUserName() != null && !users.getUserName().trim().equals("")) {
					whereList.add(criteriaBuilder.like(root.get("userName"), "%" + users.getUserName() + "%"));
				}
				if(users.getUserStatus() != -1) {
					whereList.add(criteriaBuilder.equal(root.get("userStatus"), users.getUserStatus()));
				}
				//将使用的条件以and关系联系在一起并返回
				return criteriaBuilder.and(whereList.toArray(new Predicate[whereList.size()]));
			}
		};
		//创建jpa的分页信息
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

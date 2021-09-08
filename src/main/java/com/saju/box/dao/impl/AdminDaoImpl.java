package com.saju.box.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.saju.box.dao.AdminDao;
import com.saju.box.model.LoginDto;
import com.saju.box.model.OrderDto;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Inject
	private SqlSession sqlSession;
	private String NS ="com.saju.box.adminMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
	@Override
	public LoginDto getLoginInfo(LoginDto loginDto){
		logger.info("start AdminDaoImpl.getLoginInfo!!");
		
		return sqlSession.selectOne(NS+".login",loginDto);
	}

	@Override
	public List<OrderDto> getOrderList(OrderDto orderDto) {
		logger.info("start AdminDaoImpl.getOrderList!!");
		return sqlSession.selectList(NS+".getOrderList", orderDto);
	}

	@Override
	public OrderDto getOrderDetail(OrderDto orderDto) {
		logger.info("start AdminDaoImpl.getOrderDetail!!");
		return sqlSession.selectOne(NS+".getOrderDetail", orderDto); 
	}
}

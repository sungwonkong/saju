package com.saju.box.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.saju.box.dao.OrderDao;
import com.saju.box.model.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao{
	@Inject
	private SqlSession sqlSession;
	private String NS ="com.saju.box.orderMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);
	
	@Override
	public void saveOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		
		logger.info("ksw::::"+orderDto.getOrderName());
		
		sqlSession.insert(NS+".saveOrder", orderDto);		
	}
	
	
}

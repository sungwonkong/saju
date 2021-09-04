package com.saju.box.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.saju.box.dao.OrderDao;
import com.saju.box.model.OrderDto;
import com.saju.box.service.OrderService;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	@Inject
	OrderDao orderDao;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public void saveOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		orderDao.saveOrder(orderDto);		
	}
}

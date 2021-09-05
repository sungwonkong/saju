package com.saju.box.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.saju.box.dao.AdminDao;
import com.saju.box.model.LoginDto;
import com.saju.box.model.OrderDto;
import com.saju.box.service.AdminService;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	@Inject
	AdminDao adminDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Override
	public LoginDto getLoginInfo(LoginDto loginDto){
		logger.info("START AdminServiceImpl.getLoginInfo!!!!");
		return adminDao.getLoginInfo(loginDto);		
	}

	@Override
	public List<OrderDto> getOrderList(OrderDto orderDto) {
		logger.info("START AdminServiceImpl.getOrderList!!!!");
		return adminDao.getOrderList(orderDto);
	}
}

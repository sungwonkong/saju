package com.saju.box.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.saju.box.model.LoginDto;
import com.saju.box.model.OrderDto;

@Repository
public interface AdminDao {
	public LoginDto getLoginInfo(LoginDto logindto);
	
	public List<OrderDto> getOrderList(OrderDto orderDto);
}

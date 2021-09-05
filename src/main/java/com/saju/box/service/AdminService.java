package com.saju.box.service;

import java.util.List;

import com.saju.box.model.LoginDto;
import com.saju.box.model.OrderDto;

public interface AdminService {
	public LoginDto getLoginInfo(LoginDto loginDto);
	
	public List<OrderDto> getOrderList(OrderDto orderDto);
}

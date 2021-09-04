package com.saju.box.dao;

import org.springframework.stereotype.Repository;

import com.saju.box.model.OrderDto;

@Repository
public interface OrderDao {
	public void saveOrder(OrderDto orderDto);
}

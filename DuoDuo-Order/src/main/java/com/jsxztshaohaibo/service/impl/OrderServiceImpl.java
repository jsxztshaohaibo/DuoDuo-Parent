package com.jsxztshaohaibo.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.jsxztshaohaibo.entity.OrderEntity;
import com.jsxztshaohaibo.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Override
	public OrderEntity getOrderById(String id) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(Integer.valueOf(id));
		orderEntity.setName("胡乱造名字"+id);
		orderEntity.setPrice(new BigDecimal(25.998));
		return orderEntity;
	}

}

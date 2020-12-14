package com.jsxztshaohaibo.feignApi;

import org.springframework.stereotype.Component;

import com.jsxztshaohaibo.entity.OrderEntity;
@Component
public class OrderServiceCallback implements IOrderServiceFeign {

	@Override
	public OrderEntity getOrderByIdFeign(String id) {
		System.out.println("降级容错===== OrderServiceCallback  getOrderById()   is invoked.");
		OrderEntity  OrderEntity = new OrderEntity();
		return OrderEntity;
	}

}

package com.jsxztshaohaibo.feignApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsxztshaohaibo.entity.OrderEntity;
import com.jsxztshaohaibo.service.IOrderService;


@RestController
@RequestMapping("/order")
public class OrderServiceFeign implements IOrderServiceFeign {
	
	
	@Autowired
	private IOrderService orderService;
	@Override
	@GetMapping("/getOrderByIdFeign")
	public OrderEntity getOrderByIdFeign(String id) {
		System.out.println("OrderServiceFeign  is invoked.");
		return orderService.getOrderById(id);
	}

}

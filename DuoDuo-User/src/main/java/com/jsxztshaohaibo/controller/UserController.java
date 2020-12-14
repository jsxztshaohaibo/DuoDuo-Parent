package com.jsxztshaohaibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jsxztshaohaibo.entity.OrderEntity;
import com.jsxztshaohaibo.feignApi.IOrderServiceFeign;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/findeOrder")
	public String findeOrder(@RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		String forObject = restTemplate.getForObject("http://order/order/getOrderById?id="+orderId, String.class);
		System.out.println(forObject);
		return forObject;
	}
	
	@Autowired
	private IOrderServiceFeign orderService;
	
	@GetMapping("/findeOrderByFeign")
	public String findeOrderByFeign(@RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		OrderEntity order = orderService.getOrderByIdFeign(orderId);
		System.out.println(order);
		return order.toString();
	}
}

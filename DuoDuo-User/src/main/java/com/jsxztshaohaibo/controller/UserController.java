package com.jsxztshaohaibo.controller;

import io.swagger.annotations.*;
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
@Api(value = "User功能接口",description = "User功能", tags = {"User接口"})
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/findeOrder")
	@ApiOperation(value = "查询订单接口 by restTemplate",notes = "根据用户ID和订单ID查询订单接口", position = 1)
	public String findeOrder(@ApiParam(name = "userId",value = "用户ID") @RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		String forObject = restTemplate.getForObject("http://order/order/getOrderById?id="+orderId, String.class);
		System.out.println(forObject);
		return forObject;
	}
	
	@Autowired
	private IOrderServiceFeign orderService;
	
	@GetMapping("/findeOrderByFeign")
	@ApiOperation(value = "查询订单接口 by OpenFeign",notes = "根据用户ID和订单ID查询订单接口", position = 1)
	public String findeOrderByFeign(@RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		OrderEntity order = orderService.getOrderByIdFeign(orderId);
		System.out.println(order);
		return order.toString();
	}
}

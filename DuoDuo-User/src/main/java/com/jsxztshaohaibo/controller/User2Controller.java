package com.jsxztshaohaibo.controller;

import com.jsxztshaohaibo.entity.OrderEntity;
import com.jsxztshaohaibo.feignApi.IOrderServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user2")
@Api(value = "User2功能接口",description = "User2功能", tags = {"User2接口"})
public class User2Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/findeOrder2")
	@ApiOperation(value = "查询订单接口2 by restTemplate",notes = "根据用户ID和订单ID查询订单接口", position = 1)
	public String findeOrder(@RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		String forObject = restTemplate.getForObject("http://order/order/getOrderById?id="+orderId, String.class);
		System.out.println(forObject);
		return forObject;
	}
	
	@Autowired
	private IOrderServiceFeign orderService;
	
	@GetMapping("/findeOrderByFeign2")
	@ApiOperation(value = "查询订单接口2 by OpenFeign",notes = "根据用户ID和订单ID查询订单接口", position = 1)
	public String findeOrderByFeign(@RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		OrderEntity order = orderService.getOrderByIdFeign(orderId);
		System.out.println(order);
		return order.toString();
	}


	@GetMapping("/systemuser2")
	@ApiOperation(value = "查询订单接口2 by OpenFeign",notes = "根据用户ID和订单ID查询订单接口", position = 1)
	public String systemuser2(@RequestParam(value = "userId", defaultValue = "123")String userId, @RequestParam(value = "orderId", defaultValue = "456")String orderId){
		OrderEntity order = orderService.getOrderByIdFeign(orderId);
		System.out.println(order);
		return order.toString();
	}
}

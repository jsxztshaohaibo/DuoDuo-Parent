package com.jsxztshaohaibo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsxztshaohaibo.entity.OrderEntity;
import com.jsxztshaohaibo.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/getOrderById")
	public String getOrderById(@RequestParam(value = "id", defaultValue = "123")String id,HttpServletRequest request ){
		System.out.println(request.getLocalPort());
		
		OrderEntity order = orderService.getOrderById(id);
		return order.toString();
	}
}

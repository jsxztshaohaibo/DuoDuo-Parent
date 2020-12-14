package com.jsxztshaohaibo.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsxztshaohaibo.entity.OrderEntity;


@FeignClient(value="order",fallback = OrderServiceCallback.class)
public interface IOrderServiceFeign {
	
	String API_PREFIX = "/order/";

	@GetMapping( API_PREFIX  +"getOrderByIdFeign")
	public OrderEntity getOrderByIdFeign(@RequestParam(value = "id")String id);
}

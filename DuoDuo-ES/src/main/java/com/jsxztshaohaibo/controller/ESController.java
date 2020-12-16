package com.jsxztshaohaibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsxztshaohaibo.entity.OrderES;
import com.jsxztshaohaibo.service.IESService;

@RestController
@RequestMapping(value="/es")
public class ESController {
	
	
	@Autowired
	IESService esService;
	/**
	 * 单个添加ES索引
	 * @param orderES
	 * @return
	 */
	@PostMapping(value="/add")
	public String add(@RequestBody OrderES orderES ){
		/*System.out.println("====add====");
		return "Ok";*/
		return esService.add(orderES);
	}
	
	/**
	 * 单个删除ES索引
	 * @param id
	 * @return
	 */
	@DeleteMapping(value={"/delete"})
	public String delete(@RequestParam String id){
		return  esService.delete(id);
	}
	
}

package com.jsxztshaohaibo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsxztshaohaibo.entity.OrderES;
import com.jsxztshaohaibo.mapper.ESMapper;
import com.jsxztshaohaibo.service.IESService;

@Service
public class ESServiceImpl implements IESService {
	@Autowired
	ESMapper esMapper;

	/***
	 * 增加索引
	 */
	@Override
	public String add(OrderES orderES) {
		esMapper.save(orderES);
		return "ok";
	}
	/**
	 * 删除索引
	 */
	@Override
	public String delete(String id) {
		esMapper.deleteById(id);
		return "ok";
	}

}

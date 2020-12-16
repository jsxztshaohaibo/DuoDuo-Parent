package com.jsxztshaohaibo.service;

import com.jsxztshaohaibo.entity.OrderES;

public interface IESService {
	/**
	 * 单个添加ES索引
	 * @param orderES
	 * @return
	 */
	public String add(OrderES orderES );
	
	/**
	 * 单个删除ES索引
	 * @param id
	 * @return
	 */
	public String delete(String id);
}

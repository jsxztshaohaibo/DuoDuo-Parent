package com.jsxztshaohaibo.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.jsxztshaohaibo.entity.OrderES;

public interface ESMapper extends ElasticsearchRepository<OrderES,String>{

}

package com.jsxztshaohaibo.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsxztshaohaibo.entity.OrderES;


@FeignClient(value="es",fallback=ESServiceFeignCallBack.class)
public interface IESServcieFiegn {

	String API_PREFIX = "/esFeign";
	
	/**
	 * 单个添加ES索引
	 * @param orderES
	 * @return
	 */
	@PostMapping(value=API_PREFIX+"/add")
	public String add(@RequestBody OrderES orderES );
	
	/**
	 * 单个删除ES索引
	 * @param id
	 * @return
	 */
	@DeleteMapping(value=API_PREFIX+"/delete")
	public String delete(@RequestParam String id);
	
}

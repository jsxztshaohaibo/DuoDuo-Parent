package com.jsxztshaohaibo.feignApi;

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
@RequestMapping(value="/esFeign")
public class ESServcieFeign implements IESServcieFiegn{
	@Autowired
	IESService esService;
	
	
	@Override
	@PostMapping(value="/add")
	public String add(@RequestBody OrderES orderES) {
		
		return esService.add(orderES);
	}

	@Override
	@DeleteMapping(value="/delete")
	public String delete(@RequestParam String id) {
		return esService.delete(id);
	}

}

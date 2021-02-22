package com.jsxztshaohaibo.test.pattern.chain.node;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nodechain")
public class NodeChainController {
	
	@Autowired
	Chain chain;

	@GetMapping("/do/{days}")
	public String doFilter(@PathVariable("days") Integer days){
		
		chain.handleRequest(days); 
		
		
		return "责任链执行完毕"+LocalTime.now().toString();
	}

}

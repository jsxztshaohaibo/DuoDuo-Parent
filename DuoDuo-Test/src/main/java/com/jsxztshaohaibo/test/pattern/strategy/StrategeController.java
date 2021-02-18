package com.jsxztshaohaibo.test.pattern.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strategy")
public class StrategeController {
	@Autowired
	private SMSStrategyFactory strategyFactory;
	
	//unicomSMSStrategy  moblieSMSStrategy
	@GetMapping("/map/{type}")
	public String mapStrategies(@PathVariable("type") String type){
		System.out.println(strategyFactory.getSmsStrategyMap());
		
		strategyFactory.getSmsStrategyMap().get(type).sendMsg();
		
		return  ""+strategyFactory.getSmsStrategyMap().size();
	}
	
	@GetMapping("/list/{type}")
	public String ListStrategies(@PathVariable("type") String type){
		System.out.println(strategyFactory.getSmsStrategyList());
		
		return  ""+strategyFactory.getSmsStrategyList().size();
	}
}

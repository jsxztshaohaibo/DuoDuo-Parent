package com.jsxztshaohaibo.test.pattern.chain.outer;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/outerchain")
public class OuterChainController {
	
	@Autowired
	List<Filter> filters;
	
	@GetMapping("/do")
	public String doFilter(){
		for(Filter f : filters){
			boolean res = f.filter(null);	
			System.out.println(res);
			/**是否中断， 在 每个处理器节点的    外部的此处的控制**/
			/*
			 * 有一个校验不通过的话， 执行其他的业务逻辑
			 * if(!res){
				break;
				
			}*/
		}
		/**校验通过的话， 执行其他的业务逻辑
		 * 
		 * donext。。。。
		 */
		return "责任链执行完毕"+LocalTime.now().toString();
	}

}

package com.jsxztshaohaibo.test.pattern.chain.node;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 抽象处理者：领导类
 * @author Administrator
 *
 */
@Component
public   class Chain implements InitializingBean{
	@Autowired
	List<Leader> leaders ;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 * 
	 * 设置 每个 leade中的next 的指向
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		for(int i =0;i<leaders.size();i++){
			Leader l = leaders.get(i);
			if(i== leaders.size()-1){
				l.setNext(null);
			}else{
				l.setNext(leaders.get(i+1));
			}
		}
		
	}
	
	public void handleRequest(int leaveDays){
		leaders.get(0).handleRequest(leaveDays);
	}
}
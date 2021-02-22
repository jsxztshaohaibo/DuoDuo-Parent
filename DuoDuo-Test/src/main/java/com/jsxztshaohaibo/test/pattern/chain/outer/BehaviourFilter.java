package com.jsxztshaohaibo.test.pattern.chain.outer;

import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 个人行为记录 校验器
 * @author Administrator
 *
 */
@Component
@Order(2)
public class BehaviourFilter implements Filter {

	@Override
	public boolean filter(Map params) {
		
		System.out.print("校验是否有 不良个人行为记录    ");
		
		return true;
	}

}

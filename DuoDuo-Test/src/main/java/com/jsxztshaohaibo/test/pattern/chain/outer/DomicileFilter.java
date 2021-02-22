package com.jsxztshaohaibo.test.pattern.chain.outer;

import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 稳定住所校验器
 * @author Administrator
 *
 */
@Component
@Order(3)
public class DomicileFilter implements Filter {

	@Override
	public boolean filter(Map params) {
		
		System.out.print("校验是否有稳定住所    ");
		
		return true;
	}

}

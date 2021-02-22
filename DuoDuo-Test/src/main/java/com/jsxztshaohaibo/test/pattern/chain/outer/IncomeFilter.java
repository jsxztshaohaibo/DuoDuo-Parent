package com.jsxztshaohaibo.test.pattern.chain.outer;

import java.util.Map;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 合法稳定收入校验器
 * @author Administrator
 *
 */
@Component
@Order(1)
public class IncomeFilter implements Filter {

	@Override
	public boolean filter(Map params) {
		
		System.out.print("校验是否有合法稳定收入      ");
		
		return true;
	}

}

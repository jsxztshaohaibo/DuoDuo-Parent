package com.jsxztshaohaibo.test.pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * 移动短信渠道 策略
 * @author Administrator
 *
 */
//@Component(value="unicomSMSStrategy")
@Component
public class UnicomSMSStrategy implements ISMSStrategy {

	@Override
	public void sendMsg() {
		System.out.println(".....UnicomSMSStrategy.....");

	}

}

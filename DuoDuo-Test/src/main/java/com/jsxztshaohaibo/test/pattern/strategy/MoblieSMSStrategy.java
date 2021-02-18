package com.jsxztshaohaibo.test.pattern.strategy;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *	移动短信渠道 策略
 * @author Administrator
 *
 */
//@Component(value="moblieSMSStrategy")
@Component
@Order(2)
public class MoblieSMSStrategy implements ISMSStrategy {

	@Override
	public void sendMsg() {
		System.out.println(".....MoblieSMSStrategy.....");
	}

}

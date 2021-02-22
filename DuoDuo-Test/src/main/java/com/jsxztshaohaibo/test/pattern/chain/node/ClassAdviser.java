package com.jsxztshaohaibo.test.pattern.chain.node;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 具体处理者1：班主任类
 * @author Administrator
 *
 */
@Component
@Order(1)
public class ClassAdviser extends Leader {
	
	public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 2) {
            System.out.println("【班主任】批准您请假" + LeaveDays + "天。");
        } else {
        	
        	System.out.println("---------------");
        	System.out.println("请假 超过" + LeaveDays + "天，【班主任】已无权审批，需要下一审批人进行审批。");
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
            System.out.println("---------------");
        }
    }
}
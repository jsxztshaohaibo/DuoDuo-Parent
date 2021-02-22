package com.jsxztshaohaibo.test.pattern.chain.node;

/***
 * 抽象处理者：领导类
 * @author Administrator
 *
 */
public  abstract class Leader {
	
	private  String name;
    private  Leader next;
    
    //处理请求的方法
    public abstract void handleRequest(int LeaveDays);
	
    public void setNext(Leader next) {
        this.next = next;
    }
    public Leader getNext() {
        return next;
    }
    
}
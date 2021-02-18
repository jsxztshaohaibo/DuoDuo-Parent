package com.jsxztshaohaibo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringInterfaceTest {
	private String str ;//可以打断点  "变量断点" ,变量赋值事进入断点
	
	public SpringInterfaceTest (){
		
	}
	public SpringInterfaceTest (String str){
		this.str=str;
	}
	public static void main(String[] args) {
		
		SpringInterfaceTest aa =new SpringInterfaceTest("qwe");
		
		AnnotationConfigApplicationContext annoCtx = new AnnotationConfigApplicationContext("com.jsxztshaohaibo.test");
		Test_springInteface bean = (Test_springInteface)annoCtx.getBean("test_springInteface");
		System.out.println(bean.toString());
		System.out.println("=======");
		
		
	}

	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}
}

package com.jsxztshaohaibo.test;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring Bean可以实现的 各种 工具接口，可以分别在初始化 前后、实例化 前后处理相应的逻辑 
 * @author Administrator
 *
 */
@Component
public class Test_springInteface  implements InitializingBean //为bean提供了属性初始化后的处理方法，它只包括afterPropertiesSet方法，凡是继承该接口的类，在bean的属性初始化后都会执行该方法。实现该接口的bean的所有属性都被设置后执行
											,DisposableBean //实现该接口的bean的销毁时执行，用于释放资源
											,BeanNameAware
											,ApplicationContextAware
											,BeanFactoryAware
											,FactoryBean
											,BeanPostProcessor //在每个bean初始化完成 前 后 做操作
											,BeanFactoryPostProcessor //在容器实例化任何bean之前读取bean的定义(配置元数据)，并可以修改它。同时可以定义多个BeanFactoryPostProcessor，通过设置’order’属性来确定各个BeanFactoryPostProcessor执行顺序。
											,InstantiationAwareBeanPostProcessor //继承至BeanPostProcessor，主要处理的是bean的实例化过程。
											{
	
	/**
	 * override from org.springframework.beans.factory.InitializingBean
	 */
	
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("InitializingBean   afterPropertiesSet():"+1);
	}
	/**
	 * override from org.springframework.beans.factory.DisposableBean
	 */
	public void destroy() throws Exception {
		System.out.println("DisposableBean    destroy()  "+2);

	}
	
	/**
	 *override from org.springframework.beans.factory.BeanNameAware;
	 */
	
	public void setBeanName(String name) {
		System.out.println("BeanNameAware    setBeanName("+name+")  "+3);
	}
	
	/**
	 *override from org.springframework.context.ApplicationContextAware
	 */
	
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		System.out.println("ApplicationContextAware    setApplicationContext()  "+4);

		
	}
	/**
	 *override from import org.springframework.beans.factory.BeanFactoryAware;
	 */
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryAware    setBeanFactory()  "+5);

		
	}
	
	/**
	 * org.springframework.beans.factory.FactoryBean
	 * @return
	 * @throws Exception
	 */
	
	public Object getObject() throws Exception {
		System.out.println("FactoryBean:"+ 6);
		return new Test_springInteface();
	}
	/**
	 * org.springframework.beans.factory.FactoryBean
	 * @return
	 */
	
	public Class getObjectType() {
		System.out.println("FactoryBean:  getObjectType()   "+7 + "   " + this.getClass());
		return this.getClass();
	}
	/**
	 * org.springframework.beans.factory.FactoryBean
	 * @return
	 */
	
	public boolean isSingleton() {
		System.out.println("FactoryBean:"+8);
		return true;
	}
	
	
	/**
	 * org.springframework.beans.factory.config.BeanPostProcessor
	 */
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor   before  postProcessBeforeInitialization()   :"+9);
		return bean;
	}

	/**
	 * org.springframework.beans.factory.config.BeanPostProcessor
	 */
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor   after  postProcessAfterInitialization()   :"+10);
		return bean;
	}
	
	
	/**
	 * org.springframework.beans.factory.config.BeanFactoryPostProcessor;
	 */
	
	public void postProcessBeanFactory( ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("BeanFactoryPostProcessor      postProcessBeanFactory()   :"+11);
		
	}
	
	/**
	 *org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
	 */
	
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		
		System.out.println("InstantiationAwareBeanPostProcessor  before      postProcessBeforeInstantiation()   :"+12);
		return null;
	}


	/**
	 * org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
	 */
	
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor  before      postProcessAfterInstantiation()   :"+13);
		return true;
	}

	
	/**
	 * org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
	 */
	
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {

		System.out.println("InstantiationAwareBeanPostProcessor        postProcessProperties()   :"+14);
		return null;
	}

	
	/**
	 * org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
	 */
	
	public PropertyValues postProcessPropertyValues(
			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor        postProcessPropertyValues()   :"+15);
		return pvs;
	}
}

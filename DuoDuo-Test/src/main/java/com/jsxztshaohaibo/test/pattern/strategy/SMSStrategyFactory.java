package com.jsxztshaohaibo.test.pattern.strategy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSStrategyFactory {
	
	@Autowired
	private Map<String,ISMSStrategy> smsStrategyMap;

	
	
	@Autowired
	private List<ISMSStrategy> smsStrategyList;
	
	
	
	
	
	/**
	 * @return the smsStrategyMap
	 */
	public Map<String, ISMSStrategy> getSmsStrategyMap() {
		return smsStrategyMap;
	}

	/**
	 * @param smsStrategyMap the smsStrategyMap to set
	 */
	public void setSmsStrategyMap(Map<String, ISMSStrategy> smsStrategyMap) {
		this.smsStrategyMap = smsStrategyMap;
	}

	/**
	 * @return the smsStrategyList
	 */
	public List<ISMSStrategy> getSmsStrategyList() {
		return smsStrategyList;
	}

	/**
	 * @param smsStrategyList the smsStrategyList to set
	 */
	public void setSmsStrategyList(List<ISMSStrategy> smsStrategyList) {
		this.smsStrategyList = smsStrategyList;
	}
	
	
	
}

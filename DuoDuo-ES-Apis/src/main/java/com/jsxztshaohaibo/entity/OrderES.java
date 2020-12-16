package com.jsxztshaohaibo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "es",type = "orderes")
public class OrderES implements Serializable{
	
	
	private Integer id;
	//Keyword：不分词
	@Field(type=FieldType.Keyword)
	private String name;
	private BigDecimal price;
	//Text：会进行分词
	@Field(type=FieldType.Text)
	private String newName;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the newName
	 */
	public String getNewName() {
		return newName;
	}
	/**
	 * @param newName the newName to set
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderES [id=" + id + ", name=" + name + ", price=" + price
				+ ", newName=" + newName + "]";
	}
}

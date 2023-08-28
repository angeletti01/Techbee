package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sku")
public class Sku {
	@Id
	@Column(name = "sku_id")
	private Long skuId;
	@Column(name ="type")
	private String type;
	@Column(name ="name")
	private String name;
	
	public Sku() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sku(Long skuId, String type, String name) {
		super();
		this.skuId = skuId;
		this.type = type;
		this.name = name;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sku [skuId=" + skuId + ", type=" + type + ", name=" + name + "]";
	}		
	
}

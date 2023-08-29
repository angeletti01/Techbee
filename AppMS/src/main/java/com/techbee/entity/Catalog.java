package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalog", schema = "techbee")
public class Catalog {
	@Id
	@Column(name ="catalog_id")
	private int catalogId;
	@Column(name = "sku_id")
	private int skuId;
	@Column(name ="type")
	private String type;
	@Column(name ="name")
	private String name;
	
	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalog(int catalogId, int skuId, String type, String name) {
		super();
		this.catalogId = catalogId;
		this.skuId = skuId;
		this.type = type;
		this.name = name;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
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
		return "Catalog [catalogId=" + catalogId + ", skuId=" + skuId + ", type=" + type + ", name=" + name + "]";
	}	
	
}

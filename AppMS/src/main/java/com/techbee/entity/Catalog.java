package com.techbee.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "catalog", schema = "techbee")
public class Catalog implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="catalog_id")
	private int catalogId;	
	
	@JoinColumn(name = "sku_id", referencedColumnName = "sku_id")	
	private Integer skuId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name ="sku")
	@JoinColumn(name = "sku_id", referencedColumnName = "sku_id")		
	private Sku sku;
	
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

	public void setSku(int skuId) {
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

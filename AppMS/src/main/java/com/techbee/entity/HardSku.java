package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hard_sku")
public class HardSku extends Sku {
	
	@Id
	@Column(name="hard_sku_id")
	private String hardSkuId;
	
	@Column(name="model")
	private String model;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="color")
	private String color;
	
	@Column(name="size")
	private String size;

	public HardSku() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HardSku(Long skuId, String type, String name) {
		super(skuId, type, name);
		// TODO Auto-generated constructor stub
	}

	public HardSku(String hardSkuId, String model, String manufacturer, String color, String size) {
		super();
		this.hardSkuId = hardSkuId;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
		this.size = size;
	}

	public String getHardSkuId() {
		return hardSkuId;
	}

	public void setHardSkuId(String hardSkuId) {
		this.hardSkuId = hardSkuId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "HardSku [hardSkuId=" + hardSkuId + ", model=" + model + ", manufacturer=" + manufacturer + ", color="
				+ color + ", size=" + size + "]";
	}	
	
}

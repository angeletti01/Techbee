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
}

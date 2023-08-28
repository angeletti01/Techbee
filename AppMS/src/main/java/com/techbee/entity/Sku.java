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
	
}

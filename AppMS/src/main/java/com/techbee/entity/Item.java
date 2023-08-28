package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@Column(name ="item_id")
	private int itemId;	
	@Column(name = "name")
	private String name;	
	@Column(name = "planId")
	private String planId;	
	@Column(name = "skuId")
	private String skuId;	
	@Column(name = "quantity")
	private int quantity;	
	@Column(name = "telephon_number")
	private String telephonNumber;	
	@Column(name = "status")
	private String status;	
	@Column(name = "complete")
	private boolean complete;
	

}

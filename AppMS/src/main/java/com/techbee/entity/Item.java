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
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int itemId, String name, String planId, String skuId, int quantity, String telephonNumber,
			String status, boolean complete) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.planId = planId;
		this.skuId = skuId;
		this.quantity = quantity;
		this.telephonNumber = telephonNumber;
		this.status = status;
		this.complete = complete;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTelephonNumber() {
		return telephonNumber;
	}

	public void setTelephonNumber(String telephonNumber) {
		this.telephonNumber = telephonNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", planId=" + planId + ", skuId=" + skuId + ", quantity="
				+ quantity + ", telephonNumber=" + telephonNumber + ", status=" + status + ", complete=" + complete
				+ "]";
	}
	

}

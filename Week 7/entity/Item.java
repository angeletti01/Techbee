package com.techbee.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Item", schema = "techbee")
public class Item implements Serializable{	
	
	private static final long serialVersionUID = 1L;
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
	@Column(name = "telephone_number")
	private String telephoneNumber;	
	@Column(name = "status")
	private String status;	
	@Column(name = "complete")
	private boolean complete;	
	@Column(name = "user_accepted_delay")
	private Boolean userAcceptedDelay;
	@Column(name = "delay_accepted_date")
	private String delayAcceptedDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinTable(name = "date_range")
	@JoinColumn(name = "estimated_ship_date_range", referencedColumnName = "date_range_id")
	private DateRange estimatedShipDateRange;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "date_range")
	@JoinColumn(name = "date_range_id", referencedColumnName = "date_range_id")
	private DateRange dateRangeId;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinTable(name = "date_range")
	@JoinColumn(name = "new_estimated_ship_date_range", referencedColumnName = "date_range_id")
	private DateRange newEstimatedShipDateRange;
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int itemId, String name, String planId, String skuId, int quantity, String telephoneNumber,
			String status, boolean complete, DateRange estimatedShipDateRange, DateRange newEstimatedShipDateRange,
			boolean userAcceptedDelay, String delayAcceptedDate) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.planId = planId;
		this.skuId = skuId;
		this.quantity = quantity;
		this.telephoneNumber = telephoneNumber;
		this.status = status;
		this.complete = complete;
		this.estimatedShipDateRange = estimatedShipDateRange;
		this.newEstimatedShipDateRange = newEstimatedShipDateRange;
		this.userAcceptedDelay = userAcceptedDelay;
		this.delayAcceptedDate = delayAcceptedDate;
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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
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

	public DateRange getEstimatedShipDateRange() {
		return estimatedShipDateRange;
	}

	public void setEstimatedShipDateRange(DateRange estimatedShipDateRange) {
		this.estimatedShipDateRange = estimatedShipDateRange;
	}

	public DateRange getNewEstimatedShipDateRange() {
		return newEstimatedShipDateRange;
	}

	public void setNewEstimatedShipDateRange(DateRange newEstimatedShipDateRange) {
		this.newEstimatedShipDateRange = newEstimatedShipDateRange;
	}

	public boolean isUserAcceptedDelay() {
		return userAcceptedDelay;
	}

	public void setUserAcceptedDelay(boolean userAcceptedDelay) {
		this.userAcceptedDelay = userAcceptedDelay;
	}

	public String getDelayAcceptedDate() {
		return delayAcceptedDate;
	}

	public void setDelayAcceptedDate(String delayAcceptedDate) {
		this.delayAcceptedDate = delayAcceptedDate;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", planId=" + planId + ", skuId=" + skuId + ", quantity="
				+ quantity + ", telephonNumber=" + telephoneNumber + ", status=" + status + ", complete=" + complete
				+ ", estimatedShipDateRange=" + estimatedShipDateRange + ", newEstimatedShipDateRange="
				+ newEstimatedShipDateRange + ", userAcceptedDelay=" + userAcceptedDelay + ", delayAcceptedDate="
				+ delayAcceptedDate + "]";
	}		

}

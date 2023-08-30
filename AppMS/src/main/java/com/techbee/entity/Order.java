package com.techbee.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order", schema = "techbee")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "customer_id")
	private String customerId;	
	@Column(name = "status")
	private String status;
	@Column(name = "complete")
	private boolean complete;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "item")
	@JoinColumn(name = "item", referencedColumnName = "item_id")	
	private Item item;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "address")
	@JoinColumn(name = "shipping_address", referencedColumnName = "address_id")
	private Address shippingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "shipment")
	@JoinColumn(name = "shipment_id", referencedColumnName = "shipment_id")
	private Shipment shipments;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int orderId, String customerId, Item item, String status, boolean complete,
			Address shippingAddress, Shipment shipments) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.customerId = customerId;
		this.item = item;
		this.status = status;
		this.complete = complete;
		this.shippingAddress = shippingAddress;
		this.shipments = shipments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item items) {
		this.item = items;
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

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Shipment getShipments() {
		return shipments;
	}

	public void setShipments(Shipment shipments) {
		this.shipments = shipments;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", customerId=" + customerId + ", items=" + item
				+ ", status=" + status + ", complete=" + complete + ", shippingAddress=" + shippingAddress
				+ ", shipments=" + shipments + "]";
	}	
	
}

package com.techbee.entity;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order", schema = "techbee")
public class Order {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "items")
	private Item items[];	
	@Column(name = "status")
	private String status;
	@Column(name = "complete")
	private boolean complete;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address", referencedColumnName = "address_id")
	private Address shippingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipment_id", referencedColumnName = "shipment_id")
	private Shipment[] shipments;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int orderId, String customerId, Item items[], String status, boolean complete,
			Address shippingAddress, Shipment[] shipments) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.customerId = customerId;
		this.items[id] = items[id];
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

	public Item getItems(int itemId) {
		return items[itemId];
	}

	public void setItems(Item[] items) {
		this.items = items;
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

	public Shipment getShipments(int shippingId) {
		return shipments[shippingId];
	}

	public void setShipments(Shipment[] shipments) {
		this.shipments = shipments;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", customerId=" + customerId + ", items=" + items
				+ ", status=" + status + ", complete=" + complete + ", shippingAddress=" + shippingAddress
				+ ", shipments=" + Arrays.toString(shipments) + "]";
	}	
	
}

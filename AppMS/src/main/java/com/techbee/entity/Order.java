package com.techbee.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "items")
	private List<Item> items;	
	@Column(name = "status")
	private String status;
	@Column(name = "complete")
	private boolean complete;
	@Column(name = "shipping_address")
	private Address shippingAddress;
	@Column(name = "shipments")
	private List<Shipment> shipments;
	
	

}

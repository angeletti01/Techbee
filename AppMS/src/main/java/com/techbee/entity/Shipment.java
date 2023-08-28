package com.techbee.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shipment")
public class Shipment {

	@Id
	@Column(name = "shipment_id")
	private int shipmentId;
	@Column(name = "items")
	private List<Item> items;
	@Column(name="carrier")
	private String carrier;
	@Column(name="tracking_number")
	private String trackingUrl;
	@Column(name = "shipDate")
	private String shipDate;
	
}

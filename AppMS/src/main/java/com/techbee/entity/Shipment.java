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
	
	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shipment(int shipmentId, List<Item> items, String carrier, String trackingUrl, String shipDate) {
		super();
		this.shipmentId = shipmentId;
		this.items = items;
		this.carrier = carrier;
		this.trackingUrl = trackingUrl;
		this.shipDate = shipDate;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", items=" + items + ", carrier=" + carrier + ", trackingUrl="
				+ trackingUrl + ", shipDate=" + shipDate + "]";
	}
	
	
}

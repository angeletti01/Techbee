package com.techbee.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Shipment", schema = "techbee")
public class Shipment {

	@Id
	@Column(name = "shipment_id")
	private int shipmentId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "items", referencedColumnName = "item_id")
	private Item items;
	@Column(name="carrier")
	private String carrier;
	@Column(name="tracking_number")
	private String trackingNumber;
	@Column(name = "tracking_url")
	private String trackingUrl;
	@Column(name = "estimated_delivery_date")
	private String estimatedDeliveryDate;
	@Column(name = "shipDate")
	private String shipDate;
	
	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shipment(int shipmentId, Item items, String carrier, String trackingNumber, String trackingUrl,
			String estimatedDeliveryDate, String shipDate) {
		super();
		this.shipmentId = shipmentId;
		this.items = items;
		this.carrier = carrier;
		this.trackingNumber = trackingNumber;
		this.trackingUrl = trackingUrl;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.shipDate = shipDate;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Item getItems() {
		return items;
	}

	public void setItems(Item items) {
		this.items = items;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	public String getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", items=" + items + ", carrier=" + carrier
				+ ", trackingNumber=" + trackingNumber + ", trackingUrl=" + trackingUrl + ", estimatedDeliveryDate="
				+ estimatedDeliveryDate + ", shipDate=" + shipDate + "]";
	}	
	
}

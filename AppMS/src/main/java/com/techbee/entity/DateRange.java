package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "date_range")
public class DateRange {
	
@Id
@Column(name = "date_range_id")
private int dateRateId;
@Column(name = "fromDate")
private String fromDate;
@Column(name = "toDate")
private String toDate;

public DateRange() {
	super();
	// TODO Auto-generated constructor stub
}

public DateRange(int dateRateId, String fromDate, String toDate) {
	super();
	this.dateRateId = dateRateId;
	this.fromDate = fromDate;
	this.toDate = toDate;
}

public int getDateRateId() {
	return dateRateId;
}

public void setDateRateId(int dateRateId) {
	this.dateRateId = dateRateId;
}

public String getFromDate() {
	return fromDate;
}

public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}

public String getToDate() {
	return toDate;
}

public void setToDate(String toDate) {
	this.toDate = toDate;
}

@Override
public String toString() {
	return "DateRange [dateRateId=" + dateRateId + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
}

}

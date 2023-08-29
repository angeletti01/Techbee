package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "date_range", schema = "techbee")
public class DateRange {
	
@Id
@Column(name = "date_range_id")
private int dateRangeId;
@Column(name = "fromDate")
private String fromDate;
@Column(name = "toDate")
private String toDate;

public DateRange() {
	super();
	// TODO Auto-generated constructor stub
}

public DateRange(int dateRangeId, String fromDate, String toDate) {
	super();
	this.dateRangeId = dateRangeId;
	this.fromDate = fromDate;
	this.toDate = toDate;
}

public int getDateRangeId() {
	return dateRangeId;
}

public void setDateRangeId(int dateRangeId) {
	this.dateRangeId = dateRangeId;
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
	return "DateRange [dateRangeId=" + dateRangeId + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
}

}

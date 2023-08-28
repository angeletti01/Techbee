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

}

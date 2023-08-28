package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_response")
public class ApiResponse {
	
	@Id
	@Column(name = "api_response_id")
	private int apiResponseId;
	
	@Column(name = "code")
	private int code;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "message")
	private String message;

}

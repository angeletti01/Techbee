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

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(int apiResponseId, int code, String type, String message) {
		super();
		this.apiResponseId = apiResponseId;
		this.code = code;
		this.type = type;
		this.message = message;
	}

	public int getApiResponseId() {
		return apiResponseId;
	}

	public void setApiResponseId(int apiResponseId) {
		this.apiResponseId = apiResponseId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [apiResponseId=" + apiResponseId + ", code=" + code + ", type=" + type + ", message="
				+ message + "]";
	}
	
}

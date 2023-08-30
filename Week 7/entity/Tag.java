package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag", schema = "techbee")
public class Tag {
	
	@Id
	@Column(name = "tag_id")
	private int tagId;
	
	@Column(name = "name")
	private String name;

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tag(int tagId, String name) {
		super();
		this.tagId = tagId;
		this.name = name;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", name=" + name + "]";
	}	

}

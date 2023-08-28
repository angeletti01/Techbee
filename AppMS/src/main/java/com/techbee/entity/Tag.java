package com.techbee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tag")
public class Tag {
	
	@Id
	@Column(name = "tag_id")
	private int tagId;
	
	@Column(name = "name")
	private String name;

}

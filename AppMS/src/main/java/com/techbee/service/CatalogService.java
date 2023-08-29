package com.techbee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.repo.CatalogRepo;

@Service(value = "CalalogService")
public class CatalogService {
	
	private final CatalogRepo cr;
	
	@Autowired
	public CatalogService(CatalogRepo cr) {
		this.cr = cr;
	}

}

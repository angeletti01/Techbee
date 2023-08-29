package com.techbee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.entity.Catalog;
import com.techbee.exception.CatalogNotFoundException;
import com.techbee.repo.CatalogRepo;

@Service(value = "CalalogService")
public class CatalogService {
	
	private final CatalogRepo cr;
	
	@Autowired
	public CatalogService(CatalogRepo cr) {
		this.cr = cr;
	}

	public Catalog findCatalogBySkuId(int catalogId) throws CatalogNotFoundException{
		return cr.findCatalogById(catalogId).orElseThrow(() ->
		new CatalogNotFoundException("Catalog ID: "+ catalogId + "Not Found!!!"));
	}
	
}

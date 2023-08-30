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

	public Catalog findCatalogBySkuId(int skuId) throws CatalogNotFoundException{
		return cr.findCatalogBySkuId(skuId).orElseThrow(() ->
		new CatalogNotFoundException("Catalog ID: "+ skuId + "Not Found!!!"));
	}
	
}

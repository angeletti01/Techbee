package com.techbee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.entity.Catalog;
import com.techbee.exception.CatalogNotFoundException;
import com.techbee.repo.CatalogRepo;
import com.techbee.service.CatalogService;

@RestController(value = "CatalogController")
@RequestMapping("/catalog")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogController {

	private final CatalogService cs;
	
	@Autowired
	public CatalogController(CatalogService cs) {
		this.cs = cs;
	}
	
	@GetMapping("/sku/{skuId}")
	public ResponseEntity<Catalog> getCatalogBySkuId(@PathVariable("skuId") int skuId) throws CatalogNotFoundException{
		cs.findCatalogBySkuId(skuId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

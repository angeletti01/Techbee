package com.techbee.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Catalog;

@Repository(value = "CatalogRepo")
public interface CatalogRepo extends JpaRepository <Catalog, Integer> {

	Optional<Catalog> findCatalogById(int catalogId);
	 
 
	
}

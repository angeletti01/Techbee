package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Catalog;

@Repository(value = "CatalogRepo")
public interface CatalogRepo extends JpaRepository <Catalog, Integer> {

}

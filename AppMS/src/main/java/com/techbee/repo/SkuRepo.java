package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Sku;

@Repository(value = "SkuRepo")
public interface SkuRepo extends JpaRepository<Sku, Integer>{

}

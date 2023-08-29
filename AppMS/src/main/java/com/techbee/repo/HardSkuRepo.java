package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.HardSku;

@Repository(value = "HardSkuRepo")
public interface HardSkuRepo extends JpaRepository<HardSku, String>{

}

package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Shipment;

@Repository(value = "ShipmentRepo")
public interface ShipmentRepo extends JpaRepository<Shipment, Integer> {

}

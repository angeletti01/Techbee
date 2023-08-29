package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Order;

@Repository(value = "OrderRepo")
public interface OrderRepo extends JpaRepository<Order, Integer>{

}

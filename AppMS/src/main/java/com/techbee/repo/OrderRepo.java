package com.techbee.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Item;
import com.techbee.entity.Order;

@Repository(value = "OrderRepo")
public interface OrderRepo extends JpaRepository<Order, Integer>{

	void deleteByItemId(Item items);
	Optional<Order> findByOrderId(int orderId);

}

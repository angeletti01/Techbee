package com.techbee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.entity.Item;
import com.techbee.entity.Order;
import com.techbee.entity.Shipment;
import com.techbee.exception.OrderNotFoundException;
import com.techbee.repo.OrderRepo;

@Service(value = "OrderService")
public class OrderService {

	private final OrderRepo or;
	
	@Autowired
	OrderService(OrderRepo or){
		this.or = or;
	}
	
	public Order findOrderById(int orderId) throws OrderNotFoundException {
		
		return or.findByOrderId(orderId).orElseThrow(()-> new OrderNotFoundException("Order Number: "+ orderId + "Not Found!"));
	}
	
	public String acceptShippingDate(String shippingDate) {
		Shipment s = new Shipment();
		s.setShipDate(shippingDate);
		return shippingDate;
	}
	
	public void deleteByItem(Item item) {		
		
		or.deleteOrderByItem(item);
	}
	
	public void deleteOrderById(int orderId) {
		or.deleteOrderById(orderId);
	}
}

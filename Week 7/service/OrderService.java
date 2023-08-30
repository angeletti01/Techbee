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
		
		return or.findByOrderId(orderId).orElseThrow(()-> new OrderNotFoundException("Order Number: "+ orderId + " Not Found!"));
	}
	
	public Order findOrderByItemId(int itemId) throws OrderNotFoundException{
		return or.findByItemId(itemId).orElseThrow(()-> new OrderNotFoundException("Item Number: " + itemId + " NotFound!"));
	}
	
//	public String acceptShippingDate(String shippingDate) {
//		Shipment s = new Shipment();
//		s.setShipDate(shippingDate);
//		return shippingDate;
//	}
	
	public void updateOrder(Order order) {		
		
		or.saveAndFlush(order);
	}
	
	public void deleteOrderById(int orderId) {
		or.deleteOrderById(orderId);
	}
}

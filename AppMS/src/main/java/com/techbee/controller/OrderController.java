package com.techbee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.entity.Item;
import com.techbee.entity.Order;
import com.techbee.entity.Shipment;
import com.techbee.exception.OrderNotFoundException;
import com.techbee.service.OrderService;

@RestController(value = "OrderController")
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
		
private final OrderService os;

	@Autowired
	public OrderController(OrderService os){
		this.os = os;
	}
	
	@GetMapping("{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable("orderId") int orderId) throws OrderNotFoundException{
		Order o = os.findOrderById(orderId);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@PostMapping("orderactions/acceptShipDate")
	public ResponseEntity<Order> acceptShippingDate(@PathVariable("shippingDate") String shippingDate){
		os.acceptShippingDate(shippingDate);	
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("orderactions/cancelItem/{itemId}")
	public ResponseEntity<Order> cancelItemById(@PathVariable("item") Item item){
	os.deleteByItem(item);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("orderactions/cancelOrder/{orderId}")
	public ResponseEntity<Order> cancelOrderById(@PathVariable("orderId") int orderId){
		os.deleteOrderById(orderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

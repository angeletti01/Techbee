package com.techbee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.entity.Item;
import com.techbee.entity.Order;
import com.techbee.entity.Shipment;
import com.techbee.exception.ItemNotFoundException;
import com.techbee.exception.OrderNotFoundException;
import com.techbee.service.ItemService;
import com.techbee.service.OrderService;

@RestController(value = "OrderController")
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	private final OrderService os;
	private final ItemService is;

	@Autowired
	public OrderController(OrderService os, ItemService is) {
		this.os = os;
		this.is = is;
	}

	@GetMapping("order/{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable("orderId") int orderId) throws OrderNotFoundException {
		Order o = os.findOrderById(orderId);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}	

	@PostMapping("orderactions/cancelItem/{itemId}")
	public ResponseEntity<Order> cancelItemById(@PathVariable("itemId") int itemId) throws OrderNotFoundException {
		Order o = os.findOrderByItemId(itemId);
		o.setStatus("cancel");
		os.updateOrder(o);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("orderactions/cancelOrder/{orderId}")
	public ResponseEntity<Order> cancelOrderById(@PathVariable("orderId") int orderId) throws OrderNotFoundException {

		Order o = os.findOrderById(orderId);
		o.setStatus("cancel");
		os.updateOrder(o);
		// os.deleteOrderById(orderId); // optional to delete order
		return new ResponseEntity<>(HttpStatus.OK);
	}
	// Should be in ItemController but following API Definition supplied in the OrderAPI.yaml file
	@PostMapping("orderactions/acceptShipDate/{itemId}")
	public ResponseEntity<Order> acceptShippingDate(@PathVariable("itemId") int itemId) throws ItemNotFoundException {
		Item i = is.findItemById(itemId);
		i.setUserAcceptedDelay(true);
		is.updateItem(i);
	
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

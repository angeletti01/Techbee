package com.techbee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.entity.Item;
import com.techbee.exception.ItemNotFoundException;
import com.techbee.repo.ItemRepo;

@Service(value = "ItemService")
public class ItemService {

	private final ItemRepo ir;
	
	@Autowired
	public ItemService(ItemRepo ir) {
		this.ir = ir;
	}
	
	public void updateItem(Item item) {
		ir.saveAndFlush(item);
	}
	
	public Item findItemById(int itemId) throws ItemNotFoundException {
		return ir.findById(itemId).orElseThrow(()-> new ItemNotFoundException("Item Number: " + itemId + " Not Found!"));
	}
	
}

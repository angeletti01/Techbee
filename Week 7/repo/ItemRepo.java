package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Item;

@Repository(value = "ItemRepo")
public interface ItemRepo extends JpaRepository<Item, Integer> {

}

package com.techbee.demo.week5.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.demo.week5.entity.ShoppingCart;

@Repository(value = "ShoppingCartRepository")
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer>{

}

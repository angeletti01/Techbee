package com.techbee.demo.week5.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.demo.week5.entity.Product;

@Repository(value="ProductRepository")
public interface ProductRepository extends JpaRepository<Product,Integer>{

}

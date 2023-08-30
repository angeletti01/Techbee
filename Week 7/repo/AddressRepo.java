package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Address;

@Repository(value = "AddressRepo")
public interface AddressRepo extends JpaRepository<Address, Integer> {

}

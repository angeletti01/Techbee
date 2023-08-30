package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.ApiResponse;

@Repository(value = "ApiResponseRepo")
public interface ApiResponseRepo extends JpaRepository<ApiResponse, Integer>{

}

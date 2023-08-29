package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techbee.entity.DateRange;

public interface DateRangeRepo extends JpaRepository<DateRange, Integer> {

}

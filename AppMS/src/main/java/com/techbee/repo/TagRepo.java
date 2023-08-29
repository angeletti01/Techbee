package com.techbee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.entity.Tag;

@Repository(value = "TagRepo")
public interface TagRepo extends JpaRepository<Tag, Integer> {

}

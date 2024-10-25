package com.ijse.cmjd.springpos.repository;

import com.ijse.cmjd.springpos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

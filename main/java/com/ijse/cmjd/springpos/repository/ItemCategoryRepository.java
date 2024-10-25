package com.ijse.cmjd.springpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ijse.cmjd.springpos.entity.ItemCategory;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {
}

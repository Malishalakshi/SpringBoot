package com.ijse.cmjd.springpos.repository;

import com.ijse.cmjd.springpos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}

package com.ijse.cmjd.springpos.repository;

import com.ijse.cmjd.springpos.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}

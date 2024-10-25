package com.ijse.cmjd.springpos.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.cmjd.springpos.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStock();
    Stock getStockById(Long id);
    Stock createStock(Stock stock);
    Stock updateStock(Long id, Stock stock);
    void deleteStock(Long id);
}

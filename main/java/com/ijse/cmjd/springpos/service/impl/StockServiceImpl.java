package com.ijse.cmjd.springpos.service.impl;

import java.util.List;

import com.ijse.cmjd.springpos.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.cmjd.springpos.entity.Stock;
import com.ijse.cmjd.springpos.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStock(){
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id){
        return stockRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public Stock createStock(Stock stock){
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock){
        Stock existStock = stockRepository.findById(Math.toIntExact(id)).orElse(null);

        if(existStock == null){
            return null;
        }

        existStock.setQuantity(stock.getQuantity());

        return stockRepository.save(existStock);
    }

    @Override
    public void deleteStock(Long id){
        stockRepository.deleteById(Math.toIntExact(id));
    }
}
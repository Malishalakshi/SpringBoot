package com.ijse.cmjd.springpos.service.impl;

import java.util.List;

import com.ijse.cmjd.springpos.service.StockService;
import com.ijse.cmjd.springpos.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.cmjd.springpos.entity.Item;
import com.ijse.cmjd.springpos.entity.Stock;
import com.ijse.cmjd.springpos.entity.Transaction;
import com.ijse.cmjd.springpos.repository.ItemRepository;
import com.ijse.cmjd.springpos.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StockService stockService;

    @Override
    public List<Transaction> getALLTransactions(){
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id){
        return transactionRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public Transaction createInvoice(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction addCartItem(Long transactionId, Long itemId, int quantity){
        Transaction transaction = transactionRepository.findById(Math.toIntExact(transactionId)).orElse(null);

        if(transaction == null){
            return null;
        }

        Item item = itemRepository.findById(Math.toIntExact(itemId)).orElse(null);

        if(item == null){
            return null;
        }

        Stock stock = stockService.getStockById(item.getId());

        if(stock == null){
            return null;
        }

        transaction.getSaleItems().add(item);

        transaction.setTotalPrice(transaction.getTotalPrice() + item.getPrice() * quantity);

        int newQuantity = stock.getQuantity() - quantity;

        if(newQuantity < 0){
            return null;
        }
        stock.setQuantity(newQuantity);
        stockService.updateStock(stock.getId(), stock);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction removeCartItem(Long transactionId, Long itemId, int quantity){
        Transaction transaction = transactionRepository.findById(Math.toIntExact(transactionId)).orElse(null);

        if(transaction == null){
            return null;
        }

        Item item = itemRepository.findById(Math.toIntExact(itemId)).orElse(null);

        if(item == null){
            return null;
        }

        Stock stock = stockService.getStockById(item.getId());


        transaction.getSaleItems().remove(item);

        transaction.setTotalPrice(transaction.getTotalPrice() - item.getPrice()*quantity);

        if (stock != null ) {
            stock.setQuantity(stock.getQuantity() + quantity);
            stockService.updateStock(stock.getId(), stock);
        }

        return transactionRepository.save(transaction);
    }

    public Transaction updateInvoice(Long id, Transaction transaction){
        Transaction exitsTransaction = transactionRepository.findById(Math.toIntExact(id)).orElse(null);

        if(exitsTransaction == null){
            return null;
        }

        exitsTransaction.setStatus(transaction.getStatus());
        return transactionRepository.save(exitsTransaction);
    }

}
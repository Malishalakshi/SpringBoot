package com.ijse.cmjd.springpos.service.impl;

import java.util.List;

import com.ijse.cmjd.springpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.cmjd.springpos.entity.Item;
import com.ijse.cmjd.springpos.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id){
        return itemRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item item){
        Item existItem = itemRepository.findById(Math.toIntExact(id)).orElse(null);

        if(existItem != null){
            existItem.setName(item.getName());
            existItem.setPrice(item.getPrice());

            return itemRepository.save(existItem);
        }else{
            return null;
        }
    }

    @Override
    public void deleteItem(Long id){
        itemRepository.deleteById(Math.toIntExact(id));
    }
}

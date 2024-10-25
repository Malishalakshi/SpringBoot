package com.ijse.cmjd.springpos.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.cmjd.springpos.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllItemCategories();
    ItemCategory getItemCategoryById(Long id);
    ItemCategory createItemCategory(ItemCategory itemCategory);
    ItemCategory updateItemCategory(Long id, ItemCategory itemCategory);
    void deleteItemCategory(Long id);
}

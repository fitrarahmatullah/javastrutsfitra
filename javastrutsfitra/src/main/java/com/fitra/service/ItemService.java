package com.fitra.service;

import com.fitra.dao.ItemDAO;
import com.fitra.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemDAO itemDAO;

    public void addItem(Item item) {
        itemDAO.addItem(item);
    }

    public void updateItem(Item item) {
        itemDAO.updateItem(item);
    }

    public void deleteItem(int itemId) {
        itemDAO.deleteItem(itemId);
    }

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    public Item getItemById(int itemId) {
        return itemDAO.getItemById(itemId);
    }
}

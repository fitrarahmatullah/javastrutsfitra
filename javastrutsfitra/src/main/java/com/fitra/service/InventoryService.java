package com.fitra.service;

import com.fitra.dao.InventoryDAO;
import com.fitra.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    public void topUpInventory(Inventory inventory) {
        inventoryDAO.topUpInventory(inventory);
    }

    public void withdrawInventory(Inventory inventory) {
        inventoryDAO.withdrawInventory(inventory);
    }

    public void deleteInventory(int inventoryId) {
        inventoryDAO.deleteInventory(inventoryId);
    }

    public List<Inventory> getAllInventories() {
        return inventoryDAO.getAllInventories();
    }

    public Inventory getInventoryByItemId(int itemId) {
        return inventoryDAO.getInventoryByItemId(itemId);
    }
}

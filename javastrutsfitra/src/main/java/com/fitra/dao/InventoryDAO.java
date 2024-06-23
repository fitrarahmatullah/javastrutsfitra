package com.fitra.dao;
import com.fitra.entity.Inventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void topUpInventory(Inventory inventory) {
        Inventory existingInventory = getInventoryByItemId(inventory.getItemId());
        if (existingInventory != null) {
            existingInventory.setQty(existingInventory.getQty() + inventory.getQty());
            getCurrentSession().update(existingInventory);
        } else {
            getCurrentSession().save(inventory);
        }
    }

    public void withdrawInventory(Inventory inventory) {
        Inventory existingInventory = getInventoryByItemId(inventory.getItemId());
        if (existingInventory != null) {
            existingInventory.setQty(existingInventory.getQty() - inventory.getQty());
            getCurrentSession().update(existingInventory);
        } else {
            // Handle case where inventory does not exist
            throw new RuntimeException("Inventory not found for item ID: " + inventory.getItemId());
        }
    }

    public void deleteInventory(int itemId) {
        Inventory inventory = getInventoryByItemId(itemId);
        if (inventory != null) {
            getCurrentSession().delete(inventory);
        }
    }

    public List<Inventory> getAllInventories() {
        return getCurrentSession().createQuery("FROM Inventory", Inventory.class).list();
    }

    public Inventory getInventoryByItemId(int itemId) {
        return getCurrentSession().createQuery("FROM Inventory WHERE item_id = :itemId", Inventory.class)
                .setParameter("itemId", itemId)
                .uniqueResult();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

package com.fitra.dao;

import com.fitra.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addItem(Item item) {
        getCurrentSession().save(item);
    }

    public void updateItem(Item item) {
        getCurrentSession().update(item);
    }

    public void deleteItem(int itemId) {
        Item item = getItemById(itemId);
        if (item != null) {
            getCurrentSession().delete(item);
        }
    }

    public List<Item> getAllItems() {
        return getCurrentSession().createQuery("FROM Item", Item.class).list();
    }

    public Item getItemById(int itemId) {
        return getCurrentSession().get(Item.class, itemId);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

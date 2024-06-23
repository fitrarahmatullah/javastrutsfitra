package com.fitra.dao;

import com.fitra.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void placeOrder(Order order) {
        // Assuming order_no is generated in service layer before saving
        getCurrentSession().save(order);
    }

    public void deleteOrder(String orderNo) {
        Order order = getOrderById(orderNo);
        if (order != null) {
            getCurrentSession().delete(order);
        }
    }

    public List<Order> getAllOrders() {
        return getCurrentSession().createQuery("FROM Order", Order.class).list();
    }

    public Order getOrderById(String orderNo) {
        return getCurrentSession().get(Order.class, orderNo);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

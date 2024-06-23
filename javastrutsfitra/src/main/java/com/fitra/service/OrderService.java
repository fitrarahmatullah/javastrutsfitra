package com.fitra.service;

import com.fitra.dao.OrderDAO;
import com.fitra.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public void placeOrder(Order order) {
        orderDAO.placeOrder(order);
    }

    public void deleteOrder(String orderNo) {
        orderDAO.deleteOrder(orderNo);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Order getOrderById(String orderNo) {
        return orderDAO.getOrderById(orderNo);
    }
}

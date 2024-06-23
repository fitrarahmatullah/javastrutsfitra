package com.fitra.service;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class ReportService {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> generateReport() {
        Session session = entityManager.unwrap(Session.class);
        NativeQuery<Object[]> query = session.createSQLQuery(
            "SELECT " +
            "    i.name AS item_name, " +
            "    COALESCE(SUM(o.qty), 0) AS total_orders, " +
            "    COALESCE(SUM(inv.qty), 0) AS total_inventory, " +
            "    COALESCE(SUM(o.qty) * i.price, 0) AS total_revenue " +
            "FROM " +
            "    Item i " +
            "LEFT JOIN " +
            "    Orders o ON i.ID = o.item_id " +
            "LEFT JOIN " +
            "    Inventory inv ON i.ID = inv.item_id " +
            "GROUP BY " +
            "    i.name, i.price " +
            "ORDER BY " +
            "    i.name"
        );
        return query.list();
    }
}

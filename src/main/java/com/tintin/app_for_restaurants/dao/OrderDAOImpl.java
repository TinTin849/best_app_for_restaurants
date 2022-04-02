package com.tintin.app_for_restaurants.dao;

import com.tintin.app_for_restaurants.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order");
        List<Order> allOrders = query.getResultList();

        return allOrders;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public Order getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.find(Order.class, id);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Order WHERE id = :orderId");
        query.setParameter("orderId", id);

        query.executeUpdate();
    }
}

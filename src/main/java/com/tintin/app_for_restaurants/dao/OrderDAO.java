package com.tintin.app_for_restaurants.dao;

import com.tintin.app_for_restaurants.entity.Order;

import java.util.List;

public interface OrderDAO {
    public List<Order> getAllOrders();

    public void saveOrder(Order order);

    public Order getOrder(int id);

    public void  deleteOrder(int id);
}

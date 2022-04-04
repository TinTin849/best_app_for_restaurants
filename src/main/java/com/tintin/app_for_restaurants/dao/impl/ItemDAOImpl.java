package com.tintin.app_for_restaurants.dao.impl;

import com.tintin.app_for_restaurants.dao.ItemDAO;
import com.tintin.app_for_restaurants.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Item> getAllGoods() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Item");
        List<Item> allGoods = query.getResultList();

        return allGoods;
    }

    @Override
    public void saveItem(Item item) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(item);
    }

    @Override
    public Item getItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        Item item = session.find(Item.class, id);
        return item;
    }

    @Override
    public void deleteItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Item WHERE id = :itemId");
        query.setParameter("itemId", id);

        query.executeUpdate();
    }
}

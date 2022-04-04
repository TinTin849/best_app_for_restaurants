package com.tintin.app_for_restaurants.dao.impl;

import com.tintin.app_for_restaurants.dao.ItemToSupplierDAO;
import com.tintin.app_for_restaurants.entity.ItemToSupplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ItemToSupplierDAOImpl implements ItemToSupplierDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public double getPriceByIds(int supplierId, int itemId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT price FROM ItemToSupplier WHERE supplier.id = :supplierId AND item.id = :itemId");
        query.setParameter("supplierId", supplierId);
        query.setParameter("itemId", itemId);

        double price = (double) query.getSingleResult();

        return price;
    }

    @Override
    public List<ItemToSupplier> getSupplierAndPriceByItemId(int itemId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM ItemToSupplier WHERE item.id = :itemId");
        query.setParameter("itemId", itemId);

        List<ItemToSupplier> result = query.getResultList();
        return result;
    }
}

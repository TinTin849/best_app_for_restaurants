package com.tintin.app_for_restaurants.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

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

        double price = query.getFirstResult();
        return price;
    }
}

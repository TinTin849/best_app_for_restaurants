package com.tintin.app_for_restaurants.dao;

import com.tintin.app_for_restaurants.entity.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SupplierDAOImpl implements SupplierDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Supplier> getAllSuppliers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Supplier");
        List<Supplier> allSuppliers = query.getResultList();

        return allSuppliers;
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(supplier);
    }

    @Override
    public Supplier getSupplier(int id) {
        Session session = sessionFactory.getCurrentSession();
        Supplier supplier = session.find(Supplier.class, id);
        return supplier;
    }

    @Override
    public void deleteSupplier(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Item WHERE id = :supplierId");
        query.setParameter("supplierId", id);

        query.executeUpdate();
    }
}

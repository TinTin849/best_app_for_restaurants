package com.tintin.app_for_restaurants.dao;

import com.tintin.app_for_restaurants.entity.Supplier;

import java.util.List;

public interface SupplierDAO {
    public List<Supplier> getAllSuppliers();

    public void saveSupplier(Supplier supplier);

    public Supplier getSupplier(int id);

    public void  deleteSupplier(int id);
}

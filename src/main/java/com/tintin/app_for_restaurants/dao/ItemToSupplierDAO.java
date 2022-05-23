package com.tintin.app_for_restaurants.dao;

import com.tintin.app_for_restaurants.entity.ItemToSupplier;

import java.util.List;

public interface ItemToSupplierDAO {
    public double getPriceByIds(int supplierId, int itemId);

    public List<ItemToSupplier> getSupplierAndPriceByItemId(int itemId);

    public List<ItemToSupplier> getItemAndPriceBySupplierId(int supplierId);

    public void saveItemToSupplier(ItemToSupplier itemToSupplier);
}

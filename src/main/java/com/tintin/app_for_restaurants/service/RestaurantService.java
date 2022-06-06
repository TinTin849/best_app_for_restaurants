package com.tintin.app_for_restaurants.service;

import com.tintin.app_for_restaurants.entity.Item;
import com.tintin.app_for_restaurants.entity.ItemToSupplier;
import com.tintin.app_for_restaurants.entity.Order;
import com.tintin.app_for_restaurants.entity.Supplier;

import java.util.List;

public interface RestaurantService {

    public List<Item> getAllGoods();

    public void saveItem(Item item);

    public Item getItem(int id);

    public void  deleteItem(int id);


    public List<Supplier> getAllSuppliers();

    public void saveSupplier(Supplier supplier);

    public Supplier getSupplier(int id);

    public void  deleteSupplier(int id);


    public List<Order> getAllOrders();

    public void saveOrder(Order order);

    public Order getOrder(int id);

    public void  deleteOrder(int id);


    public double getPriceByIds(int supplierId, int itemId);
    public List<ItemToSupplier> getSupplierAndPriceByItemId(int itemId);
    public List<ItemToSupplier> getItemAndPriceBySupplierId(int supplierId);
    public void saveItemToSupplier(ItemToSupplier itemToSupplier);

    public void deleteItemInSupplier(ItemToSupplier itemToSupplier);
}

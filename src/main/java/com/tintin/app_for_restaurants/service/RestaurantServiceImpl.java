package com.tintin.app_for_restaurants.service;

import com.tintin.app_for_restaurants.dao.ItemDAO;
import com.tintin.app_for_restaurants.dao.ItemToSupplierDAO;
import com.tintin.app_for_restaurants.dao.OrderDAO;
import com.tintin.app_for_restaurants.dao.SupplierDAO;
import com.tintin.app_for_restaurants.entity.Item;
import com.tintin.app_for_restaurants.entity.ItemToSupplier;
import com.tintin.app_for_restaurants.entity.Order;
import com.tintin.app_for_restaurants.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final ItemDAO itemDAO;

    private final SupplierDAO supplierDAO;

    private final OrderDAO orderDAO;

    private final ItemToSupplierDAO itemToSupplierDAO;

    @Autowired
    public RestaurantServiceImpl(ItemDAO itemDAO,
                                 SupplierDAO supplierDAO,
                                 OrderDAO orderDAO,
                                 ItemToSupplierDAO itemToSupplierDAO) {
        this.itemDAO = itemDAO;
        this.supplierDAO = supplierDAO;
        this.orderDAO = orderDAO;
        this.itemToSupplierDAO = itemToSupplierDAO;
    }

    @Override
    @Transactional
    public List<Item> getAllGoods() {
        return itemDAO.getAllGoods();
    }

    @Override
    @Transactional
    public void saveItem(Item item) {
        itemDAO.saveItem(item);
    }

    @Override
    @Transactional
    public Item getItem(int id) {
        return itemDAO.getItem(id);
    }

    @Override
    @Transactional
    public void deleteItem(int id) {
        itemDAO.deleteItem(id);
    }

    @Override
    @Transactional
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    @Override
    @Transactional
    public void saveSupplier(Supplier supplier) {
        supplierDAO.saveSupplier(supplier);
    }

    @Override
    @Transactional
    public Supplier getSupplier(int id) {
        return supplierDAO.getSupplier(id);
    }

    @Override
    @Transactional
    public void deleteSupplier(int id) {
        supplierDAO.deleteSupplier(id);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }

    @Override
    @Transactional
    public double getPriceByIds(int supplierId, int itemId) {
        return itemToSupplierDAO.getPriceByIds(supplierId, itemId);
    }

    @Override
    @Transactional
    public List<ItemToSupplier> getSupplierAndPriceByItemId(int itemId) {
        return itemToSupplierDAO.getSupplierAndPriceByItemId(itemId);
    }

    @Override
    @Transactional
    public List<ItemToSupplier> getItemAndPriceBySupplierId(int supplierId) {
        return itemToSupplierDAO.getItemAndPriceBySupplierId(supplierId);
    }

    @Override
    @Transactional
    public void saveItemToSupplier(ItemToSupplier itemToSupplier) {
        itemToSupplierDAO.saveItemToSupplier(itemToSupplier);
    }

    @Override
    public void deleteItemInSupplier(ItemToSupplier itemToSupplier) {
        itemToSupplierDAO.deleteItemInSupplier(itemToSupplier);
    }
}

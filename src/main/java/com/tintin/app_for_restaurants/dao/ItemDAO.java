package com.tintin.app_for_restaurants.dao;

import com.tintin.app_for_restaurants.entity.Item;

import java.util.List;

public interface ItemDAO {
    public List<Item> getAllGoods();

    public void saveItem(Item item);

    public Item getItem(int id);

    public void  deleteItem(int id);
}

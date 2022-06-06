package com.tintin.app_for_restaurants.controller;

import com.tintin.app_for_restaurants.entity.Item;
import com.tintin.app_for_restaurants.entity.ItemToSupplier;
import com.tintin.app_for_restaurants.entity.Supplier;
import com.tintin.app_for_restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/edit-supplier")
public class EditSupplierController {

    private final RestaurantService restaurantService;

    @Autowired
    public EditSupplierController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping()
    public String editSupplier(@ModelAttribute("supplierId") Supplier supplierId
            , Model model) {

        Supplier realSupplier = restaurantService.getSupplier(supplierId.getId());
        model.addAttribute("realSupplier", realSupplier);

        List<ItemToSupplier> chosenItemsAndPrices = new ArrayList<>();
        if (supplierId.getId() != -1) {
            chosenItemsAndPrices = restaurantService.getItemAndPriceBySupplierId(supplierId.getId());
        }
        model.addAttribute("chosenItemsAndPrices", chosenItemsAndPrices);

        List<Item> usedItems = new ArrayList<>();
        for (ItemToSupplier itemToSupplier : chosenItemsAndPrices) {
            usedItems.add(itemToSupplier.getItem());
        }
        List<Item> unusedItems = restaurantService.getAllGoods();
        unusedItems.removeAll(usedItems);
        model.addAttribute("unusedItems", unusedItems);

        ItemToSupplier itemAndPrice = new ItemToSupplier();
        model.addAttribute("itemAndPrice", itemAndPrice);

        return "edit-supplier";
    }

    @RequestMapping("/add-item-to-supplier")
    public String addItemToSupplier(@ModelAttribute("itemAndPrice") ItemToSupplier itemToSupplier
            , Model model) {

        restaurantService.saveItemToSupplier(itemToSupplier);

        return "redirect:/edit-supplier";
    }

    @RequestMapping("/delete-item")
    public String deleteItem(@ModelAttribute("itemAndPrice") ItemToSupplier itemToSupplier) {

        restaurantService.deleteItemInSupplier(itemToSupplier);

        return "redirect:/edit-supplier";
    }
}

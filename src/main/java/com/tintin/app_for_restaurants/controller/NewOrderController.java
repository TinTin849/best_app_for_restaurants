package com.tintin.app_for_restaurants.controller;

import com.tintin.app_for_restaurants.entity.Item;
import com.tintin.app_for_restaurants.entity.ItemToSupplier;
import com.tintin.app_for_restaurants.entity.Order;
import com.tintin.app_for_restaurants.entity.Supplier;
import com.tintin.app_for_restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/new-order")
public class NewOrderController {

    private final RestaurantService restaurantService;

    @Autowired
    public NewOrderController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Page for making of new orders
    @RequestMapping()
    public String newOrder(@ModelAttribute("item") Item item
            , Model model) {

        List<Item> allGoods = restaurantService.getAllGoods();
        model.addAttribute("allGoods", allGoods);

        List<ItemToSupplier> chosenSuppliersAndPrices = new ArrayList<>();
        if (item.getId() != -1) {
            chosenSuppliersAndPrices = restaurantService.getSupplierAndPriceByItemId(item.getId());
        }
        model.addAttribute("chosenSuppliersAndPrices", chosenSuppliersAndPrices);

        return "new-order";
    }

    @RequestMapping("/add-order")
    public String addOrder(@RequestParam(value = "numberToOrder") int numberToOrder
            , @RequestParam(value = "supplierName") int supplierId
            , @RequestParam(value = "itemName") int itemId) {

        Item orderedItem = restaurantService.getItem(itemId);
        Supplier orderedSupplier = restaurantService.getSupplier(supplierId);
        double totalPrice = restaurantService.getPriceByIds(supplierId, itemId) * numberToOrder;

        Order newOrder = new Order(orderedItem, orderedSupplier, numberToOrder, totalPrice, LocalDate.now());
        restaurantService.saveOrder(newOrder);

        orderedItem.setNumberOfItems(orderedItem.getNumberOfItems() + numberToOrder);
        restaurantService.saveItem(orderedItem);

        return "redirect:/";
    }
}
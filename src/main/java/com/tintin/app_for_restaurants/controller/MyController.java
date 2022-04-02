package com.tintin.app_for_restaurants.controller;

import com.tintin.app_for_restaurants.entity.Item;
import com.tintin.app_for_restaurants.entity.Order;
import com.tintin.app_for_restaurants.entity.Supplier;
import com.tintin.app_for_restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/")
    public String showAllGoods(Model model) {

        List<Item> allGoods = restaurantService.getAllGoods();
        model.addAttribute("allGoods", allGoods);

        return "all-goods";
    }

    @RequestMapping("/writeOffOfGoods")
    public String writeOffOfGoods(@RequestParam("itemId") int id
            , @RequestParam("numberToWriteOff") int numberToWriteOff) {

        Item item = restaurantService.getItem(id);

        item.setNumberOfItems(item.getNumberOfItems() - numberToWriteOff);

        restaurantService.saveItem(item);

        return "redirect:/";
    }

    @RequestMapping("/fixGoods")
    public String fixGoods(Model model) {

        List<Item> allGoods = restaurantService.getAllGoods();
        model.addAttribute("allGoods", allGoods);

        return "fix-goods";
    }

    @RequestMapping("/updateWarehouse")
    public String updateWarehouse(@RequestParam("itemId") int id
            , @RequestParam("numberToSet") int numberToSet) {

        Item item = restaurantService.getItem(id);

        item.setNumberOfItems(numberToSet);

        restaurantService.saveItem(item);

        return "redirect:/fixGoods";
    }

    @RequestMapping("/newOrder")
    public String newOrder(@RequestParam(value = "itemId", required = false) int id
            , Model model) {

        List<Item> allGoods = restaurantService.getAllGoods();
        model.addAttribute("allGoods", allGoods);

        Map<Supplier, Double> supplierPrice = new HashMap<>();
        if (id != 0) {
            Item chosenItem = restaurantService.getItem(id);
            List<Supplier> suppliers = restaurantService.getAllSuppliers();

            for (Supplier currentSup : suppliers) {
                if (currentSup.getGoods().contains(chosenItem)) {
                    Double price = restaurantService.getPriceByIds(currentSup.getId(), chosenItem.getId());

                    supplierPrice.put(currentSup, price);
                }
            }
        }
        model.addAttribute("suitableSuppliers", supplierPrice);

        return "new-order";
    }

    @RequestMapping("/addOrder")
    public String addOrder() {
        Order newOrder = new Order();

        restaurantService.saveOrder();
    }

}

package com.tintin.app_for_restaurants.controller;

import com.tintin.app_for_restaurants.entity.Item;
import com.tintin.app_for_restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/fix-warehouse")
public class FixWarehouseController {

    private final RestaurantService restaurantService;

    @Autowired
    public FixWarehouseController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Page for direct fix of goods in warehouse
    @RequestMapping()
    public String fixGoods(Model model) {

        List<Item> allGoods = restaurantService.getAllGoods();
        model.addAttribute("allGoods", allGoods);

        return "fix-goods";
    }

    @RequestMapping("/update-warehouse")
    public String updateWarehouse(@RequestParam("itemId") int id
            , @RequestParam("numberToSet") int numberToSet) {

        Item item = restaurantService.getItem(id);

        item.setNumberOfItems(numberToSet);

        restaurantService.saveItem(item);

        return "redirect:/fix-warehouse";
    }
}

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
@RequestMapping("/")
public class GoodsPageController {

    private final RestaurantService restaurantService;

    @Autowired
    public GoodsPageController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Page for goods list and writing them off
    @RequestMapping()
    public String showAllGoods(Model model) {

        List<Item> allGoods = restaurantService.getAllGoods();
        model.addAttribute("allGoods", allGoods);

        return "all-goods";
    }

    @RequestMapping("/write-off-of-goods")
    public String writeOffOfGoods(@RequestParam("itemId") int id
            , @RequestParam("numberToWriteOff") int numberToWriteOff) {

        Item item = restaurantService.getItem(id);

        item.setNumberOfItems(item.getNumberOfItems() - numberToWriteOff);

        restaurantService.saveItem(item);

        return "redirect:/";
    }
}

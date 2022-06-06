package com.tintin.app_for_restaurants.controller;

import com.tintin.app_for_restaurants.entity.Order;
import com.tintin.app_for_restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/all-orders")
public class AllOrdersController {

    private final RestaurantService restaurantService;

    @Autowired
    public AllOrdersController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Page for orders list and deleting them
    @RequestMapping()
    public String showAllOrders(Model model) {

        List<Order> allOrders = restaurantService.getAllOrders();
        model.addAttribute("allOrders", allOrders);

        return "all-orders";
    }

    @RequestMapping("/delete-order")
    public String deleteOrder(@RequestParam("orderId") int id) {

        restaurantService.deleteOrder(id);

        return "redirect:/all-orders";
    }
}

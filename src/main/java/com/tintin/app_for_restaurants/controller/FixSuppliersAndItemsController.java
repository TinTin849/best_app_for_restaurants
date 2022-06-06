package com.tintin.app_for_restaurants.controller;

import com.tintin.app_for_restaurants.entity.Supplier;
import com.tintin.app_for_restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fix-suppliers-and-items")
public class FixSuppliersAndItemsController {

    private final RestaurantService restaurantService;

    @Autowired
    public FixSuppliersAndItemsController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Page for choosing pages for editing
    @RequestMapping()
    public String fixSuppliersAndItems(@ModelAttribute("supplierId") Supplier supplier
            , Model model) {

        List<Supplier> allSuppliers = restaurantService.getAllSuppliers();
        model.addAttribute("allSuppliers", allSuppliers);

        return "fix-suppliers-and-items";
    }
}

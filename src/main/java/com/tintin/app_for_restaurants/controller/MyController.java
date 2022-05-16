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
public class MyController {

    private final RestaurantService restaurantService;

    @Autowired
    public MyController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

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

    @RequestMapping("/addOrder")
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

    @RequestMapping("/allOrders")
    public String showAllOrders(Model model) {

        List<Order> allOrders = restaurantService.getAllOrders();
        model.addAttribute("allOrders", allOrders);

        return "all-orders";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") int id) {

        restaurantService.deleteOrder(id);

        return "redirect:/allOrders";
    }

    @RequestMapping("/fixSuppliersAndItems")
    public String fixSuppliersAndItems(@ModelAttribute("supplier") Supplier supplier
            , Model model) {

        List<Supplier> allSuppliers = restaurantService.getAllSuppliers();
        model.addAttribute("allSuppliers", allSuppliers);

        System.out.println(supplier.getId());

        return "fix-suppliers-and-items";
    }

    @RequestMapping("/editSupplier")
    public String editSupplier(Model model) {

        return "edit-supplier";
    }
}

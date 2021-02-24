package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.*;
import pl.gastromanager.service.*;
import pl.gastromanager.util.OrderMealsUtils;
import pl.gastromanager.util.OrderUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/orders")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping("/all")
    public String showAllOrders(Model model) {
        List<Orders> allOrders = ordersService.findAllOrders();
        model.addAttribute("orders", allOrders);
        return "orders/list";
    }

    @RequestMapping("/{id}")
    public String showOrder(@PathVariable("id") long id, Model model) {
        Optional<Orders> order = ordersService.getOrders(id);
        model.addAttribute("order", order);
        return "orders/getOrder";
    }

    @RequestMapping("/add")
    public String showFormToAddOrders(Model model) {
        model.addAttribute("order", new Orders());
        return "orders/add";
    }

    @PostMapping("/add")
    public String saveNewOrders(Orders orders) {
        ordersService.addOrders(orders);
        return "redirect:/admin/orders/all";
    }

    @RequestMapping("/edit/{id}")
    public String edidOrderForm(@PathVariable("id") Long id, Model model) {
        Orders order = ordersService.getOrders(id).get();
        model.addAttribute("order", order);
        return "orders/edit";
    }

    @PostMapping("/edit")
    public String editOrder(Orders orders) {
        ordersService.editOrders(orders);
        return "redirect:/admin/orders/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        ordersService.deleteOrders(id);
        return "redirect:/admin/orders/all";
    }



    //PRINTING SHOPPING CART IN CONSOLE
    private void printShoppingCart(Orders orders) {
        if (orders.getOrderMeals() != null) {
            System.out.println(orders.getOrderMeals().size());
            orders.getOrderMeals().forEach(
                    el -> {
                        System.out.println("OrderType: " + el.getOrderType() + "\n");
                        el.getPlansMeals().forEach(pm -> System.out.println(pm.getMeal().getName()));
                        System.out.println("----------------------");
                    }
            );
        }
    }
}

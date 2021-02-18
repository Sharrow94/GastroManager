package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Orders;
import pl.gastromanager.service.OrdersService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
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
        return "redirect:/orders/all";
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
        return "redirect:/orders/all";
    }
    @RequestMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        ordersService.deleteOrders(id);
        return "redirect:/orders/all";
    }
}

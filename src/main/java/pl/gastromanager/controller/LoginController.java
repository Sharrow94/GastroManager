package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;
import pl.gastromanager.model.PlansMeals;
import pl.gastromanager.model.Users;
import pl.gastromanager.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"shoppingCart", "shoppingItem"})
@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("shoppingCart")
    public Orders shoppingCart() {
        Orders order = new Orders();
        order.setOrderMeals(new ArrayList<>());
        return order;
    }

//    @ModelAttribute("shoppingItem")
//    public OrderMeals shoppingItem(){
//        return new OrderMeals();
//    }

    @GetMapping("")
    public String index(Model model){
        return "redirect:/home";
    }
    @GetMapping("/test")
    @ResponseBody
    public String showCart(@SessionAttribute("shoppingCart") Orders orders){
        System.out.println(orders);
        return "";
    }

    @GetMapping("/home")
    public String landingPage(){
        return "home";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public  String addUser(Model model){
        model.addAttribute("user", new Users());
        return "user/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveAddUser(@Valid @ModelAttribute ("user") Users user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/registration";
        }
        userService.add(user);
        userService.saveUser(user);
        return "redirect:/home";
    }


}

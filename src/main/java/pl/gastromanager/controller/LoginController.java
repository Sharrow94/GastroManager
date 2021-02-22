package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;
import pl.gastromanager.model.PlansMeals;

import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"shoppingCart", "shoppingItem"})
@Controller
public class LoginController {

    @ModelAttribute("shoppingCart")
    public Orders shoppingCart() {
        return new Orders();
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


}

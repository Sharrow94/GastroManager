package pl.gastromanager.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.Users;
import pl.gastromanager.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
//    private final Validator validator;

    public UserController(UserService userService ) {
        this.userService = userService;
    }



    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<Users> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/allUser";
    }

    @RequestMapping("/add")
    public  String addUser(Model model){
        model.addAttribute("user", new Users());
        return "user/addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAddUser(@Valid @ModelAttribute ("user") Users user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/addUser";
        }
        userService.add(user);
        userService.saveUser(user);
        return "redirect:/all";
    }


    @RequestMapping(value = "/edit/{id}")
    public String editUser (@PathVariable long id, Model model){
        model.addAttribute("user", userService.get(id));
        return "user/editUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveEditUser (@Valid @ModelAttribute ("user") Users user, BindingResult result){
        if(result.hasErrors()){
            return "user/editUser";
        }
        userService.update(user);
        return "redirect:/all";
    }


    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userService.delete(id);
        return "redirect:/all";

    }

}

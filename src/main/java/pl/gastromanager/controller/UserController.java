package pl.gastromanager.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gastromanager.model.Users;
import pl.gastromanager.service.UserService;

import javax.validation.Valid;
import java.util.List;



@Controller
@RequestMapping("/admin/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService ) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<Users> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/allUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public  String addUser(Model model){
        model.addAttribute("user", new Users());
        return "user/registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAddUser(@Valid @ModelAttribute ("user") Users user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/registration";
        }
        userService.add(user);
        userService.saveUser(user);
        return "redirect:/home";
    }
//Dla Admina
    @RequestMapping(value = "/edit/{id}")
    public String editUser (Model model, @PathVariable Long id){
        model.addAttribute("user", userService.get(id));
        return "user/editUserAll";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String saveEditUser (@Valid @ModelAttribute ("user") Users user,@PathVariable Long id, BindingResult result){
        if(result.hasErrors()){
            return "user/editUserAll";
        }
        userService.add(user);
        return "redirect:/admin/user/all";
    }
//Dla zalogowanego użytkownika
    @RequestMapping(value = "/edit")
    public String editUser (Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = userService.findByUserName(auth.getName());
        Long id = currentUser.getId();
        model.addAttribute("user", userService.get(id));
        return "user/editUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveEditUser (@Valid @ModelAttribute ("user") Users user,  BindingResult result){
        if(result.hasErrors()){
            return "user/editUser";
        }
        userService.add(user);
        return "redirect:/admin/user/all";
    }


    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userService.delete(id);
        return "redirect:/admin/user/all";

    }

}

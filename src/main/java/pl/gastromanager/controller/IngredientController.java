package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Ingredient;
import pl.gastromanager.service.IngredientService;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @RequestMapping("/{id}")
    public String getIngredient(@PathVariable("id") Long id, Model model){
        model.addAttribute("ingredient",ingredientService.findById(id).get());
        return "ingredient/showDetails";
    }

    @RequestMapping("/all")
    public String getAllIngredients(Model model){
        model.addAttribute("ingredients",ingredientService.findAll());
        return "ingredient/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id")Long id){
        ingredientService.deleteIngredient(id);
        return "redirect:/ingredient/all";
    }

    @RequestMapping("/add")
    public String addIngredient(Model model){
        Ingredient ingredient=new Ingredient();
        model.addAttribute("ingredient",ingredient);
        return "ingredient/addIngredient";
    }

    @PostMapping("/add")
    public String ingredientAddForm(Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return "redirect:/ingredient/all";
    }

    @RequestMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id") Long id,Model model){
        Ingredient ingredient=ingredientService.findById(id).get();
        model.addAttribute("ingredient",ingredient);
        return "ingredient/editIngredient";
    }

    @PostMapping("/update")
    public String ingredientEditForm(Ingredient ingredient){
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredient/all";
    }
}

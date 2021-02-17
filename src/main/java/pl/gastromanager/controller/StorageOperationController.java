package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.StorageOperation;
import pl.gastromanager.service.IngredientService;
import pl.gastromanager.service.StorageOperationService;

import java.util.List;

@Controller
@RequestMapping("/storageOperation")
public class StorageOperationController {

    private final StorageOperationService storageOperationService;
    private final IngredientService ingredientService;

    public StorageOperationController(StorageOperationService storageOperationService, IngredientService ingredientService) {
        this.storageOperationService = storageOperationService;
        this.ingredientService = ingredientService;
    }


    @RequestMapping("/{id}")
    public String getIngredient(@PathVariable("id") Long id, Model model) {
        model.addAttribute("storageOperation", storageOperationService.findById(id).get());
        return "storageOperation/showDetails";
    }

    @RequestMapping("/all")
    public String getAllIngredients(Model model) {
        model.addAttribute("storageOperations", storageOperationService.findAll());
        return "storageOperation/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id") Long id) {
        storageOperationService.deleteStorageOperation(id);
        return "redirect:/storageOperation/list";
    }

    @RequestMapping("/add")
    public String addStorageOperation(Model model) {
        StorageOperation storageOperation = new StorageOperation();
        List<Ingredient> ingredientList=ingredientService.findAll();
        model.addAttribute("ingredients",ingredientList);
        model.addAttribute("storageOperation", storageOperation);
        return "storageOperation/add";
    }

    @PostMapping("/add")
    public String ingredientAddForm(StorageOperation storageOperation) {
        storageOperationService.addStorageOperation(storageOperation);
        return "redirect:/storageOperation/list";
    }

    @RequestMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id") Long id, Model model) {
        StorageOperation storageOperation = storageOperationService.findById(id).get();
        model.addAttribute("storageOperation", storageOperation);
        return "storageOperation/edit";
    }

    @PostMapping("/update")
    public String ingredientEditForm(StorageOperation storageOperation) {
        storageOperationService.saveStorageOperation(storageOperation);
        return "redirect:/storageOperation/list";
    }
}
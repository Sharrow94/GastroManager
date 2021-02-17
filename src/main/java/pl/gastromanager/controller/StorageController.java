package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Storage;
import pl.gastromanager.service.StorageService;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/storage")
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }


    @RequestMapping("/all")
    public String showAllStorage(Model model) {
        List<Storage> storages = storageService.findAllIngredientInStorage();
        model.addAttribute("storages", storages);
        return "storage/list";
    }

    @RequestMapping("/{id}")
    public String showOneIngredientInStorage(@PathVariable("id") long id, Model model) {
        Optional<Storage> ingredientInStorage = storageService.getIngredientToStorage(id);
        model.addAttribute("ingredientInStorage", ingredientInStorage);
        return "/storage/ingredientInStorage";
    }


    @RequestMapping("/add")
    public String showFormToAddIngredientToStorage(Model model) {
        model.addAttribute("storage", new Storage());
        return "storage/add";
    }

    @PostMapping("/add")
    public String saveNewIngredientInStorage(Storage storage) {
        storageService.addIngredientToStorage(storage);
        return "redirect:/storage/all";
    }


    @RequestMapping("/edit/{id}")
    public String editIngredientInStorage(@PathVariable("id") long id, Model model) {
        Storage storage = storageService.getIngredientToStorage(id).get();
        model.addAttribute("storage", storage);
        return "storage/edit";
    }


    @PostMapping("/edit")
    public String editIngredientInStorage(Storage storage) {
        storageService.editIngredientInStorage(storage);
        return "redirect:/storage/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteIngredientInStorage(@PathVariable("id") long id) {
        storageService.deleteIngredientInStorage(id);
        return "redirect:/storage/all";
    }
}



package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.StorageOperation;
import pl.gastromanager.service.IngredientService;
import pl.gastromanager.service.StorageOperationItemService;
import pl.gastromanager.service.StorageOperationService;
import pl.gastromanager.service.SupplierService;

@Controller
@RequestMapping("/admin/storageOperation")
public class StorageOperationController {

    private final StorageOperationService storageOperationService;
    private final IngredientService ingredientService;
    private final StorageOperationItemService storageOperationItemService;

    public StorageOperationController(StorageOperationService storageOperationService,
                                      IngredientService ingredientService,
                                      StorageOperationItemService storageOperationItemService) {
        this.storageOperationService = storageOperationService;
        this.ingredientService = ingredientService;
        this.storageOperationItemService = storageOperationItemService;
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
        Long sOiId = storageOperationService.findById(id).get().getStorageOperationItem().getId();
        Long ingredientId = storageOperationService.findById(id).get().getIngredient().getId();
        storageOperationService.deleteStorageOperation(id);
        storageOperationService.updateTotalQuantityIngredient(ingredientId);
        return "redirect:/admin/sOi/details/" + sOiId;
    }

    @RequestMapping("/add/{id}")
    public String addIngredientToSoI(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sOi", storageOperationItemService.findById(id).get());
        model.addAttribute("storageOperation", new StorageOperation());
        model.addAttribute("ingredients", ingredientService.findAll());
        return "/storageOperation/add";
    }

    @PostMapping("/add")
    public String addIngredientPost(StorageOperation storageOperation) {
        if (!storageOperation.getStorageOperationItem().getOperationType().equals("WZ")) {
            storageOperation.setQuantity(storageOperation.getQuantity() * (-1));
        }
        storageOperationService.addStorageOperation(storageOperation);
        storageOperationService.updateTotalQuantityIngredient(storageOperation.getIngredient().getId());
        storageOperationService.updateAvgUnitPriceOfIngredient(storageOperation.getIngredient().getId());
        return "redirect:/admin/sOi/details/" + storageOperation.getStorageOperationItem().getId();
    }

    @RequestMapping("/edit/{id}")
    public String editIngredient(@PathVariable("id") Long id, Model model) {
        StorageOperation storageOperation = storageOperationService.findById(id).get();
        if (!storageOperation.getStorageOperationItem().getOperationType().equals("WZ")) {
            storageOperation.setQuantity(storageOperation.getQuantity() * (-1));
        }
        model.addAttribute("storageOperation", storageOperation);
        model.addAttribute("ingredients", ingredientService.findAll());
        return "storageOperation/edit";
    }

    @PostMapping("/update")
    public String ingredientEditForm(StorageOperation storageOperation) {
        if (!storageOperation.getStorageOperationItem().getOperationType().equals("WZ")) {
            storageOperation.setQuantity(storageOperation.getQuantity() * (-1));
        }
        storageOperationService.saveStorageOperation(storageOperation);
        System.out.println(storageOperation.getStorageOperationItem().getDocumentNumber());
        storageOperationService.updateTotalQuantityIngredient(storageOperation.getIngredient().getId());
        storageOperationService.updateAvgUnitPriceOfIngredient(storageOperation.getIngredient().getId());
        return "redirect:/admin/sOi/details/" + storageOperation.getStorageOperationItem().getId();
    }
}

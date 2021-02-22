package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.StorageOperation;
import pl.gastromanager.model.StorageOperationItem;
import pl.gastromanager.service.IngredientService;
import pl.gastromanager.service.StorageOperationItemService;
import pl.gastromanager.service.StorageOperationService;
import pl.gastromanager.service.SupplierService;

import java.time.LocalDate;

@Controller
@RequestMapping("/sOi")
public class StorageOperationItemController {

    private final StorageOperationItemService storageOperationItemService;
    private final SupplierService supplierService;
    private final StorageOperationService storageOperationService;
    private final IngredientService ingredientService;

    public StorageOperationItemController(StorageOperationItemService storageOperationItemService, SupplierService supplierService, StorageOperationService storageOperationService, IngredientService ingredientService) {
        this.storageOperationItemService = storageOperationItemService;
        this.supplierService = supplierService;
        this.storageOperationService = storageOperationService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/details/{id}")
    public String getSoI(@PathVariable("id") Long id, Model model){
        model.addAttribute("soi",storageOperationItemService.findById(id).get());
        model.addAttribute("operations",storageOperationService.findAllByStorageOperationItemId(id));
        return "storageOperationItem/showDetails";
    }

    @RequestMapping("/list")
    public String getAll(Model model){
        model.addAttribute("storageOperationItems",storageOperationItemService.findAll());
        return "storageOperationItem/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSoI(@PathVariable("id")Long id){
        storageOperationItemService.deleteSOI(id);
        return "redirect:/sOi/list";
    }

    @RequestMapping("/add")
    public String addSoI(Model model){
        StorageOperationItem sOi=new StorageOperationItem();
        model.addAttribute("suppliers",supplierService.findAll());
        model.addAttribute("sOi",sOi);

        return "storageOperationItem/add";
    }

    @PostMapping("/add")
    public String sOiAddForm(StorageOperationItem sOi){
        sOi.setDate(LocalDate.now());
        storageOperationItemService.addSOI(sOi);
        return "redirect:/sOi/list";
    }

    @RequestMapping("/edit/{id}")
    public String editSoI(@PathVariable("id") Long id,Model model){
        StorageOperationItem sOi=storageOperationItemService.findById(id).get();
        model.addAttribute("soi",sOi);
        return "storageOperationItem/edit";
    }

    @PostMapping("/update")
    public String sOiEditForm(StorageOperationItem sOi){
        storageOperationItemService.saveSOI(sOi);
        return "redirect:/sOi/list";
    }
}

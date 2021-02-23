package pl.gastromanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gastromanager.model.Supplier;
import pl.gastromanager.service.SupplierService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping("/all")
    public String showAllSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);

        return "supplier/list";
    }

    @RequestMapping("/{id}")
    public String showOneSupplier(@PathVariable("id") long id, Model model) {
        Optional<Supplier> supplier = supplierService.getSupplier(id);
        model.addAttribute("supplier", supplier);
        return "supplier/supplierView";
    }


    @RequestMapping("/add")
    public String showFormToAddSupplier(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/add";
    }

    @PostMapping("/add")
    public String saveNewSupplier(Supplier supplier) {
        supplierService.add(supplier);
        return "redirect:/admin/supplier/all";
    }


    @RequestMapping("/edit/{id}")
    public String editSupplier(@PathVariable("id") long id, Model model) {
        Supplier supplier = supplierService.getSupplier(id).get();
        model.addAttribute("supplier", supplier);
        return "supplier/edit";
    }


    @PostMapping("/edit")
    public String editSupplier(Supplier supplier) {
        supplierService.editSupplier(supplier);
        return "redirect:/admin/supplier/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable("id") long id) {
        supplierService.delete(id);
        return "redirect:/admin/supplier/all";
    }
}


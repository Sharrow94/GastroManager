package pl.gastromanager.service;

import pl.gastromanager.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService  {
    List<Supplier> findAll ();
    Optional<Supplier> getSupplier(long id);
    void add(Supplier supplier);
    void delete(Long id);
    void editSupplier(Supplier supplier);
    void updateAbleToDelete(Long id);//<--- need Supplier ID
}
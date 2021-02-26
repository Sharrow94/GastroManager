package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Supplier;
import pl.gastromanager.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @Override
    public void add(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);

    }

    @Override
    public List<Supplier> findAll() {
        return  supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> getSupplier(long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void editSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
        updateAbleToDelete(supplier.getId());

    }

    @Override
    public void updateAbleToDelete(Long id) {
        Supplier supplier=supplierRepository.findById(id).get();
        Long sum=supplierRepository.getCountOfIdsWithSuppId(id);
        supplier.setAbleToRemove(sum == 0);
        supplierRepository.save(supplier);
    }
}

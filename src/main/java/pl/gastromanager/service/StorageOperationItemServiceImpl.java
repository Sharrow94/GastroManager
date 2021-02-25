package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.StorageOperationItem;
import pl.gastromanager.repository.StorageOperationItemRepository;
import java.util.List;
import java.util.Optional;


@Service
public class StorageOperationItemServiceImpl implements StorageOperationItemService {

    private final StorageOperationItemRepository storageOperationItemRepository;
    private final SupplierServiceImpl supplierService;


    public StorageOperationItemServiceImpl(StorageOperationItemRepository storageOperationItemRepository, SupplierServiceImpl supplierService) {
        this.storageOperationItemRepository = storageOperationItemRepository;
        this.supplierService = supplierService;
    }

    @Override
    public Optional<StorageOperationItem> findById(Long id) {
        return storageOperationItemRepository.findById(id);
    }

    @Override
    public void saveSOI(StorageOperationItem storageOperationItem) {
        storageOperationItemRepository.save(storageOperationItem);
        supplierService.updateAbleToDelete(storageOperationItem.getSupplier().getId());
    }

    @Override
    public void addSOI(StorageOperationItem storageOperationItem) {
        storageOperationItemRepository.save(storageOperationItem);
        supplierService.updateAbleToDelete(storageOperationItem.getSupplier().getId());
    }

    @Override
    public void deleteSOI(Long id) {
        StorageOperationItem soi=storageOperationItemRepository.findById(id).get();
        storageOperationItemRepository.deleteById(id);
        supplierService.updateAbleToDelete(soi.getSupplier().getId());
    }

    @Override
    public List<StorageOperationItem> findAll() {
        return storageOperationItemRepository.findAll();
    }

    @Override
    public List<Long> ingredientsToUpdateAfterRemoveSoI(Long id) {
        return storageOperationItemRepository.ingredientsToUpdateAfterRemoveSoI(id);
    }


}

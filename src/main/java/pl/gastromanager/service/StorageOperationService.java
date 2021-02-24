package pl.gastromanager.service;


import pl.gastromanager.model.StorageOperation;
import java.util.List;
import java.util.Optional;

public interface StorageOperationService {

    Optional<StorageOperation> findById(Long id);
    void saveStorageOperation(StorageOperation storageOperation);
    void addStorageOperation(StorageOperation storageOperation);
    void deleteStorageOperation(Long id);
    List<StorageOperation> findAll();
    List<StorageOperation>findAllByStorageOperationItemId(Long id);
    void updateTotalQuantityIngredient(Long id);
    void updateAvgUnitPriceOfIngredient(Long id);
    void deleteAllBySoIID(Long id);
}

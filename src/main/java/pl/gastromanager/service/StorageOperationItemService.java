package pl.gastromanager.service;

import pl.gastromanager.model.StorageOperationItem;
import java.util.List;
import java.util.Optional;

public interface StorageOperationItemService {
    Optional<StorageOperationItem> findById(Long id);
    void saveSOI(StorageOperationItem storageOperationItem);
    void addSOI(StorageOperationItem storageOperationItem);
    void deleteSOI(Long id);
    List<StorageOperationItem> findAll();
}

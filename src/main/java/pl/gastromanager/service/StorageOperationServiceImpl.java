package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.StorageOperation;
import pl.gastromanager.repository.StorageOperationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StorageOperationServiceImpl implements StorageOperationService {

    private final StorageOperationRepository storageOperationRepository;

    public StorageOperationServiceImpl(StorageOperationRepository storageOperationRepository) {
        this.storageOperationRepository = storageOperationRepository;
    }

    @Override
    public Optional<StorageOperation> findById(Long id) {
        return storageOperationRepository.findById(id);
    }

    @Override
    public void saveStorageOperation(StorageOperation storageOperation) {
        storageOperationRepository.save(storageOperation);
    }

    @Override
    public void addStorageOperation(StorageOperation storageOperation) {
        storageOperationRepository.save(storageOperation);
    }

    @Override
    public void deleteStorageOperation(Long id) {
        storageOperationRepository.deleteById(id);
    }

    @Override
    public List<StorageOperation> findAll() {
        return storageOperationRepository.findAll();
    }
}

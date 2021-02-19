package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.StorageOperationItem;
import pl.gastromanager.repository.StorageOperationItemRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StorageOperationItemServiceImpl implements StorageOperationItemService {

    private final StorageOperationItemRepository storageOperationItemRepository;

    public StorageOperationItemServiceImpl(StorageOperationItemRepository storageOperationItemRepository) {
        this.storageOperationItemRepository = storageOperationItemRepository;
    }

    @Override
    public Optional<StorageOperationItem> findById(Long id) {
        return storageOperationItemRepository.findById(id);
    }

    @Override
    public void saveSOI(StorageOperationItem storageOperationItem) {
        storageOperationItemRepository.save(storageOperationItem);
    }

    @Override
    public void addSOI(StorageOperationItem storageOperationItem) {
        storageOperationItemRepository.save(storageOperationItem);
    }

    @Override
    public void deleteSOI(Long id) {
        storageOperationItemRepository.deleteById(id);
    }

    @Override
    public List<StorageOperationItem> findAll() {
        return storageOperationItemRepository.findAll();
    }

}

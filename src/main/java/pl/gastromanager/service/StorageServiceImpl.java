package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Storage;
import pl.gastromanager.repository.StorageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public List<Storage> findAllIngredientInStorage() {
        return storageRepository.findAll();
    }

    @Override
    public Optional<Storage> getIngredientToStorage(long id) {
        return storageRepository.findById(id);
    }

    @Override
    public void addIngredientToStorage(Storage storage) {
        storageRepository.save(storage);

    }

    @Override
    public void deleteIngredientInStorage(Long id) {
        storageRepository.deleteById(id);

    }

    @Override
    public void editIngredientInStorage(Storage storage) {
        storageRepository.save(storage);

    }
}

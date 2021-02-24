package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.StorageOperation;
import pl.gastromanager.repository.StorageOperationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StorageOperationServiceImpl implements StorageOperationService {

    private final StorageOperationRepository storageOperationRepository;
    private final IngredientService ingredientService;

    public StorageOperationServiceImpl(StorageOperationRepository storageOperationRepository, IngredientService ingredientService) {
        this.storageOperationRepository = storageOperationRepository;
        this.ingredientService = ingredientService;
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

    @Override
    public List<StorageOperation> findAllByStorageOperationItemId(Long id) {
        return storageOperationRepository.findAllByStorageOperationItemId(id);
    }

    @Override
    public void updateTotalQuantityIngredient(Long id) {
        Ingredient ingredient=ingredientService.findById(id).get();
        Float quantity=storageOperationRepository.getTotalQuantityIngredient(id);
        if (quantity!=null){
            ingredient.setCurrentQuantity(quantity);
        }else {
        ingredient.setCurrentQuantity(0);
        }
        ingredientService.saveIngredient(ingredient);
    }

    @Override
    public void updateAvgUnitPriceOfIngredient(Long id) {
        Float currentPrice=storageOperationRepository.updateIngredientPriceFromLastMonth(id);
        Ingredient ingredient=ingredientService.findById(id).get();
        if (currentPrice!=null){
            ingredient.setUnitPrice(currentPrice);
        }else {
            ingredient.setUnitPrice(0);
        }
        ingredientService.saveIngredient(ingredient);
    }

    @Override
    public void deleteAllBySoIID(Long id) {
        storageOperationRepository.removeAllBySoIId(id);
    }
}

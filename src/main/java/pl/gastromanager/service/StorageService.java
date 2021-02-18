package pl.gastromanager.service;

import pl.gastromanager.model.Storage;

import java.util.List;
import java.util.Optional;

public interface StorageService {
    List<Storage> findAllIngredientInStorage ();
    Optional<Storage> getIngredientToStorage(long id);
    void addIngredientToStorage(Storage storage);
    void deleteIngredientInStorage(Long id);
    void editIngredientInStorage(Storage storage);
}

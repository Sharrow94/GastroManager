package pl.gastromanager.service;

import pl.gastromanager.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {

    Optional<Ingredient> findById(Long id);
    void saveIngredient(Ingredient ingredient);
    void addIngredient(Ingredient ingredient);
    void deleteIngredient(Long id);
    List<Ingredient>findAll();
}

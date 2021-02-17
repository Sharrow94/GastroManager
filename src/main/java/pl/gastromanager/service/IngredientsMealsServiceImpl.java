package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.IngredientsMeals;
import pl.gastromanager.repository.IngredientsMealsRepository;

@Service
public class IngredientsMealsServiceImpl implements IngredientsMealsService {
    private final IngredientsMealsRepository ingredientsMealsRepository;

    public IngredientsMealsServiceImpl(IngredientsMealsRepository ingredientsMealsRepository) {
        this.ingredientsMealsRepository = ingredientsMealsRepository;
    }

    @Override
    public void saveIngredientsMeals(IngredientsMeals ingredientsMeals) {
        ingredientsMealsRepository.save(ingredientsMeals);
    }

    @Override
    public IngredientsMeals findIngredientsMealsById(Long id) {
        return ingredientsMealsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("IM does not exists"));
    }

    @Override
    public void deleteIngredientsMeals(IngredientsMeals ingredientsMeals) {
        ingredientsMealsRepository.delete(ingredientsMeals);
    }
}

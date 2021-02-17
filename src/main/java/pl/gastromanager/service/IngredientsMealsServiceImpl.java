package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.IngredientsMeals;
import pl.gastromanager.repository.IngredientsMealsRepository;

@Service
public class IngredientsMealsServiceImpl implements IngredientsMealsService{
    private final IngredientsMealsRepository ingredientsMealsRepository;

    public IngredientsMealsServiceImpl(IngredientsMealsRepository ingredientsMealsRepository) {
        this.ingredientsMealsRepository = ingredientsMealsRepository;
    }

    @Override
    public void saveIngredientsMeals(IngredientsMeals ingredientsMeals) {
        ingredientsMealsRepository.save(ingredientsMeals);
    }
}

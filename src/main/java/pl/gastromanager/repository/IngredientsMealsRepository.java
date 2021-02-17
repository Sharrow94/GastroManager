package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.IngredientsMeals;
import pl.gastromanager.model.Meal;

import java.util.List;

@Repository
public interface IngredientsMealsRepository extends JpaRepository<IngredientsMeals, Long> {
    List<IngredientsMeals> findAllIngredientsByMeal(Meal meal);
}

package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.Meal;

import java.util.List;
import java.util.Set;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findFirstByName(String name);
}

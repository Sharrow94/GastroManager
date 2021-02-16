package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findFirstByName(String name);
}

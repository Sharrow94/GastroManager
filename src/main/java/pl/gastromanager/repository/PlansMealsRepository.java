package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.PlansMeals;

@Repository
public interface PlansMealsRepository extends JpaRepository<PlansMeals, Long> {
}

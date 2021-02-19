package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.MealName;

@Repository
public interface MealNameRepository extends JpaRepository<MealName, Long> {
}

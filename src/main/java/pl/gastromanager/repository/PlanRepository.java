package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Plan;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {
    Optional<Plan> findById(Long id);
}

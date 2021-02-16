package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
    Diet findDietByName(String name);
}

package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.WeekDays;
import java.util.Optional;

@Repository
public interface WeekDaysRepository extends JpaRepository<WeekDays,Long> {

    Optional<WeekDays> findById(Long id);
    Optional<WeekDays> findByName(String name);
}

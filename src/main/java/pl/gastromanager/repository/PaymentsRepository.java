package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments,Long> {
}

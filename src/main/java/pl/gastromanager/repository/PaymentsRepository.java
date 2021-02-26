package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Payments;

import java.util.List;


@Repository
public interface PaymentsRepository extends JpaRepository<Payments,Long> {
    List<Payments> findAllByUsersId(long id);
}

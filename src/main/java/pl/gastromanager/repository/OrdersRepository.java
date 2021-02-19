package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gastromanager.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}

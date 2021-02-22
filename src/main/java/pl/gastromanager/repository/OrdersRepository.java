package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.gastromanager.model.Orders;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}

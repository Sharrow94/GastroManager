package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;

import java.util.List;

@Repository
public interface OrderMealsRepository extends JpaRepository<OrderMeals, Long> {
    List<OrderMeals> findAllByOrder(Orders orders);
}

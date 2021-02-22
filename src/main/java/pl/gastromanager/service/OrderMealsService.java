package pl.gastromanager.service;

import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;

import java.util.List;

public interface OrderMealsService {
    List<OrderMeals> findAll();
    List<OrderMeals> findAllByOrder(Orders order);
    void delete(OrderMeals orderMeals);
    void save(OrderMeals orderMeals);
    void edit(OrderMeals orderMeals);
    OrderMeals findById(Long id);
}

package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;
import pl.gastromanager.repository.OrderMealsRepository;

import java.util.List;

@Service
public class OrderMealsServiceImpl implements OrderMealsService{
    private final OrderMealsRepository orderMealsRepository;

    public OrderMealsServiceImpl(OrderMealsRepository orderMealsRepository) {
        this.orderMealsRepository = orderMealsRepository;
    }

    @Override
    public List<OrderMeals> findAll() {
        return orderMealsRepository.findAll();
    }

    @Override
    public List<OrderMeals> findAllByOrder(Orders order) {
//        return orderMealsRepository.findAllByOrder(order);
        return null;
    }

    @Override
    public void delete(OrderMeals orderMeals) {
        orderMealsRepository.delete(orderMeals);
    }

    @Override
    public void save(OrderMeals orderMeals) {
        orderMealsRepository.save(orderMeals);
    }

    @Override
    public void edit(OrderMeals orderMeals) {
        orderMealsRepository.save(orderMeals);
    }

    @Override
    public OrderMeals findById(Long id) {
        return orderMealsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("OrderMeal does not exists"));
    }
}

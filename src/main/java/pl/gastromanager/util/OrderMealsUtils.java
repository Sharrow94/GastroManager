package pl.gastromanager.util;


import pl.gastromanager.model.OrderMeals;

public interface OrderMealsUtils {
    float getPriceByMeals(OrderMeals orderMeals);
    float getPriceByPlan(OrderMeals orderMeals);
}

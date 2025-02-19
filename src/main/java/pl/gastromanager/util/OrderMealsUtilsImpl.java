package pl.gastromanager.util;

import org.springframework.stereotype.Component;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.PlansMeals;


@Component
public class OrderMealsUtilsImpl implements OrderMealsUtils{

    @Override
    public float getPriceByMeals(OrderMeals orderMeals){
        return (float) Math.round(orderMeals.getPlansMeals().stream()
                .map(PlansMeals::getMeal)
                .map(Meal::getPrice)
                .reduce(Float::sum)
                .orElse(0f)*100)/100;
    }

    @Override
    public float getPriceByPlan(OrderMeals orderMeals){
        return (float) Math.round(orderMeals.getPlansMeals().stream()
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("PlanMeals not found"))
                .getPlan()
                .getPrice()*100)/100;
    }
}

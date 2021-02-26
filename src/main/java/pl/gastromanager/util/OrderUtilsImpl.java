package pl.gastromanager.util;

import org.springframework.stereotype.Component;
import pl.gastromanager.model.Orders;

@Component
public class OrderUtilsImpl implements OrderUtils {
    @Override
    public float countTotalPrice(Orders order) {
        return (float) Math.round(order.getOrderMeals()
                .stream()
                .map(om-> (float) Math.round(om.getQuantity()*om.getPrice()*100)/100)
                .reduce(Float::sum)
                .orElse(0f)*100)/100;
    }
}

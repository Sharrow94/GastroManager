package pl.gastromanager.service;

import pl.gastromanager.model.Orders;
import pl.gastromanager.model.Payments;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> findAllOrders();

    Optional<Orders> getOrders(long id);

    void addOrders(Orders orders);

    void deleteOrders(Long id);

    void editOrders(Orders orders);
}

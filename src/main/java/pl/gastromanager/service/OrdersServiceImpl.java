package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Orders;
import pl.gastromanager.repository.OrdersRepository;

import java.util.List;
import java.util.Optional;
@Service
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrders(long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public void addOrders(Orders orders) {
        ordersRepository.save(orders);

    }

    @Override
    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);

    }

    @Override
    public void editOrders(Orders orders) {
        ordersRepository.save(orders);
    }
}

package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.OrderMeals;
import pl.gastromanager.model.Orders;
import pl.gastromanager.model.Payments;
import pl.gastromanager.model.Users;
import pl.gastromanager.repository.PaymentsRepository;
import pl.gastromanager.repository.RoleRepository;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    private final PaymentsRepository paymentsRepository;
    private final RoleRepository roleRepository;
    private final OrdersService ordersService;
    private final OrderMealsService orderMealsService;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository, RoleRepository roleRepository, OrdersService ordersService, OrderMealsService orderMealsService) {
        this.paymentsRepository = paymentsRepository;
        this.roleRepository = roleRepository;
        this.ordersService = ordersService;
        this.orderMealsService = orderMealsService;
    }

    @Override
    public List<Payments> findAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public Payments getPayment(long id) {
        return paymentsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Payment does not exists"));
    }

    @Override
    public void addPayments(Payments payments) {
        paymentsRepository.save(payments);

    }

    @Override
    public void deletePayment(Long id) {
        paymentsRepository.deleteById(id);
    }

    @Override
    public void editPayment(Payments payments) {
        paymentsRepository.save(payments);
    }

    @Override
    public Payments findPaymentsByUserId() {
        return null;
    }

    @Override
    public List<Payments> findPaymentsByUserId(Long id) {
        return paymentsRepository.findAllByUsersId(id);
    }

    @Override
    public List<String> findAllRolesByUserId(Long id) {
        return roleRepository.findAllRolesByUserId(id);
    }


}
package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Payments;
import pl.gastromanager.repository.PaymentsRepository;
import pl.gastromanager.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    private final PaymentsRepository paymentsRepository;
    private final RoleRepository roleRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository, RoleRepository roleRepository) {
        this.paymentsRepository = paymentsRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Payments> findAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public Optional<Payments> getPayment(long id) {
        return paymentsRepository.findById(id);
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
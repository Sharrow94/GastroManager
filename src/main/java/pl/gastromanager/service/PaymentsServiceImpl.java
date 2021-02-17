package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Payments;
import pl.gastromanager.repository.PaymentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    private final PaymentsRepository paymentsRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
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
}

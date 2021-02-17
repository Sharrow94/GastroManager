package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Payments;
import pl.gastromanager.model.Storage;

import java.util.List;
import java.util.Optional;


public interface PaymentsService {
    List<Payments> findAllPayments();
    Optional<Payments> getPayment(long id);
    void addPayments(Payments payments);
    void deletePayment(Long id);
    void editPayment(Payments payments);
}

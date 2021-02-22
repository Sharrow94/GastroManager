package pl.gastromanager.service;

import pl.gastromanager.model.Payments;

import java.util.List;
import java.util.Optional;


public interface PaymentsService {
    List<Payments> findAllPayments();
    Optional<Payments> getPayment(long id);
    void addPayments(Payments payments);
    void deletePayment(Long id);
    void editPayment(Payments payments);
    Payments findPaymentsByUserId();
    List<Payments> findPaymentsByUserId(Long id);
    List<String>findAllRolesByUserId(Long id);

}

package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Supplier;
import pl.gastromanager.service.SupplierService;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

}

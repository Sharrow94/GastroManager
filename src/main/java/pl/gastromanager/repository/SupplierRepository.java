package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Supplier;
import pl.gastromanager.service.SupplierService;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    @Query(value = "select count(id) from storage_operation_item where supplier_id=?1",nativeQuery = true)
    Long getCountOfIdsWithSuppId(Long id);

}

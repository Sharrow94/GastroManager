package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.StorageOperation;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StorageOperationRepository extends JpaRepository<StorageOperation,Long> {
    List<StorageOperation>findAllByStorageOperationItemId(Long id);
    List<StorageOperation>findAllByIngredientId(Long id);
    @Query( value="select sum(quantity) from storage_operation where ingredient_id=?1", nativeQuery = true)
            Float getTotalQuantityIngredient(Long id);
    @Query(value = "select AVG(unit_price) from storage_operation_item join storage_operation so on storage_operation_item.id = so.storage_operation_item_id where operation_type='WZ' and timestampdiff(day,date,now())<30 and ingredient_id=?1",nativeQuery = true)
    Float updateIngredientPriceFromLastMonth(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from storage_operation where storage_operation_item_id=?1",nativeQuery = true)
    void removeAllBySoIId(Long id);
}

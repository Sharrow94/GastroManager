package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.StorageOperationItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface StorageOperationItemRepository extends JpaRepository<StorageOperationItem,Long> {
    Optional<StorageOperationItem> findById(Long id);

    @Query("select so.ingredient.id from StorageOperation so where so.storageOperationItem.id=:id")
    List<Long> ingredientsToUpdateAfterRemoveSoI(Long id);
}

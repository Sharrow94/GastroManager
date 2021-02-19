package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.StorageOperationItem;

import java.util.Optional;

@Repository
public interface StorageOperationItemRepository extends JpaRepository<StorageOperationItem,Long> {
    Optional<StorageOperationItem> findById(Long id);
}

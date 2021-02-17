package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.StorageOperation;

@Repository
public interface StorageOperationRepository extends JpaRepository<StorageOperation,Long> {
}

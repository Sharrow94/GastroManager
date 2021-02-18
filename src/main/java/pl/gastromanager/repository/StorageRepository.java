package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Storage;
@Repository
public interface StorageRepository extends JpaRepository<Storage,Long> {
}

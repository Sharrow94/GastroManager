package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Users;

import java.util.Locale;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);

}

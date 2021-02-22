package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Ingredient;
import java.util.Optional;


@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

    Optional<Ingredient> findById(Long id);

    @Query("select i.currentQuantity from Ingredient i where i.id=:id ")
    Long getTotalQofIngredient(Long id);


}

package pl.gastromanager.service;

import pl.gastromanager.model.Meal;
import pl.gastromanager.model.Plan;
import java.util.List;
import java.util.Optional;

public interface PlanService {
    Optional<Plan> findById(Long id);
    void savePlan(Plan plan);
    void addPlan(Plan plan);
    void deletePlan(Long id);
    List<Plan> findAll();
    List<Meal> findAllPlanMeals(Plan plan);
    void refreshPlan(Plan plan);
}

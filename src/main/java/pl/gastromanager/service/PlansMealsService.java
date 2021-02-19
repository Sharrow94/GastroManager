package pl.gastromanager.service;


import pl.gastromanager.model.Plan;
import pl.gastromanager.model.PlansMeals;

public interface PlansMealsService {
    void savePlansMeals(PlansMeals plansMeals);
    void deletePlansMeals(PlansMeals plansMeals);
    PlansMeals findPlansMealsById(Long id);
    void editPlansMeals(PlansMeals plansMeals);
}

package pl.gastromanager.service;


import pl.gastromanager.model.*;

import java.util.List;
import java.util.Set;

public interface PlansMealsService {
    void savePlansMeals(PlansMeals plansMeals);
    void deletePlansMeals(PlansMeals plansMeals);
    PlansMeals findPlansMealsById(Long id);
    void editPlansMeals(PlansMeals plansMeals);
    PlansMeals findFirstByMeal(Meal meal);
    List<PlansMeals> findAllByPlan(Plan plan);
    List<PlansMeals> findAllByPlanAndWeekDays(Plan plan, WeekDays weekDays);
}

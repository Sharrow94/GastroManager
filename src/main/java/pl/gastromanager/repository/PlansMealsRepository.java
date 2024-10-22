package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.*;

import java.util.List;


@Repository
public interface PlansMealsRepository extends JpaRepository<PlansMeals, Long> {
    PlansMeals findFirstByMeal(Meal meal);
    List<PlansMeals> findAllByPlan(Plan plan);
    @Query("select pm from PlansMeals pm where pm.plan=?1 and pm.weekDays=?2")
    List<PlansMeals> findAllByPlanAndWeekDays(Plan plan, WeekDays weekDays);
    PlansMeals findFirstByMealAndAndMealName(Meal meal, MealName mealName);
}

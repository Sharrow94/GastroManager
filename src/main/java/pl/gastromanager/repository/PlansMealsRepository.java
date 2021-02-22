package pl.gastromanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.Plan;
import pl.gastromanager.model.PlansMeals;
import pl.gastromanager.model.WeekDays;

import java.util.List;


@Repository
public interface PlansMealsRepository extends JpaRepository<PlansMeals, Long> {
    PlansMeals findFirstByMeal(Meal meal);
    List<PlansMeals> findAllByPlan(Plan plan);
    List<PlansMeals> findAllByPlanAndWeekDays(Plan plan, WeekDays weekDays);
}

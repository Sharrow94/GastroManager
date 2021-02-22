package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.*;
import pl.gastromanager.repository.PlansMealsRepository;

import java.util.List;
import java.util.Set;

@Service
public class PlansMealsServiceImpl implements PlansMealsService {
    PlansMealsRepository plansMealsRepository;

    public PlansMealsServiceImpl(PlansMealsRepository plansMealsRepository) {
        this.plansMealsRepository = plansMealsRepository;
    }

    @Override
    public void savePlansMeals(PlansMeals plansMeals) {
        plansMealsRepository.save(plansMeals);
    }

    @Override
    public void deletePlansMeals(PlansMeals plansMeals) {
        plansMealsRepository.delete(plansMeals);
    }

    @Override
    public PlansMeals findPlansMealsById(Long id) {
        return plansMealsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("PM does not exists"));
    }

    @Override
    public void editPlansMeals(PlansMeals plansMeals) {
        plansMealsRepository.save(plansMeals);
    }

    @Override
    public List<PlansMeals> findAllByPlan(Plan plan) {
        return plansMealsRepository.findAllByPlan(plan);
    }

    @Override
    public PlansMeals findFirstByMeal(Meal meal) {
        return plansMealsRepository.findFirstByMeal(meal);
    }

    @Override
    public List<PlansMeals> findAllByPlanAndWeekDays(Plan plan, WeekDays weekDays) {
        return plansMealsRepository.findAllByPlanAndWeekDays(plan, weekDays);
    }
}

package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.PlansMeals;
import pl.gastromanager.repository.PlansMealsRepository;

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
}

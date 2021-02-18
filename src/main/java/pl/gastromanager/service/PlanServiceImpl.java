package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.Plan;
import pl.gastromanager.model.PlansMeals;
import pl.gastromanager.repository.PlanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    @Override
    public void savePlan(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public void addPlan(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public List<Meal> findAllPlanMeals(Plan plan) {
        return plan.getPlansMeals()
                .stream()
                .map(PlansMeals::getMeal)
                .collect(Collectors.toList());
    }

    @Override
    public void refreshPlan(Plan plan) {
        List<Meal> meals = findAllPlanMeals(plan);
        Float summaryPrice = meals.stream()
                .map(Meal::getPrice)
                .reduce(Float::sum)
                .orElse(0f);

        plan.setPrice(summaryPrice);
        planRepository.save(plan);
    }
}

package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Diet;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.Plan;
import pl.gastromanager.model.PlansMeals;
import pl.gastromanager.repository.DietRepository;
import pl.gastromanager.repository.PlanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;
    private final DietRepository dietRepository;

    public PlanServiceImpl(PlanRepository planRepository, DietRepository dietRepository) {
        this.planRepository = planRepository;
        this.dietRepository = dietRepository;
    }

    @Override
    public Plan findById(Long id) {
        return planRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Plan does not exists"));
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
        //Setting plan's price
        List<Meal> meals = findAllPlanMeals(plan);
        Float summaryPrice = meals.stream()
                .map(Meal::getPrice)
                .reduce(Float::sum)
                .orElse(0f);

        plan.setFoodCostTotal(summaryPrice);

        //Setting plan's properties
        plan.setHasMeat(false);
        plan.setHasLactose(false);
        plan.setHasGluten(false);
        for (Meal meal : meals) {
            if(meal.isHasGluten()) plan.setHasGluten(true);
            if(meal.isHasLactose()) plan.setHasLactose(true);
            if(meal.isHasMeat()) plan.setHasMeat(true);
        }

        //Setting plan's diet
        List<Diet> diets = dietRepository.findAll();
        diets.forEach(diet->{
            if(diet.isHasGluten()==plan.isHasGluten() && diet.isHasLactose()==plan.isHasLactose() && diet.isHasMeat()==plan.isHasMeat()){
                plan.setDiet(diet);
            }
        });


        planRepository.save(plan);
    }
}

package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Plan;
import pl.gastromanager.repository.PlanRepository;

import java.util.List;
import java.util.Optional;

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
}

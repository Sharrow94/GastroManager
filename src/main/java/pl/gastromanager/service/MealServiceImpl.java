package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Meal;
import pl.gastromanager.repository.MealRepository;

import java.util.List;


@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public void saveMeal(Meal meal) {
        mealRepository.save(meal);
    }

    @Override
    public void deleteMeal(Meal meal) {
        mealRepository.delete(meal);
    }

    @Override
    public Meal updateMeal(Meal meal) {
        mealRepository.save(meal);
        return meal;
    }

    @Override
    public Meal findMealById(Long id) {
        return mealRepository.findById(id).orElseThrow(()->new IllegalArgumentException("This Meal does not exists"));
    }

    @Override
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal findMealByName(String name) {
        return mealRepository.findFirstByName(name);
    }
}

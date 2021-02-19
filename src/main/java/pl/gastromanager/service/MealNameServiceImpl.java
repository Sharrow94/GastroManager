package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Meal;
import pl.gastromanager.model.MealName;
import pl.gastromanager.repository.MealNameRepository;

import java.util.List;

@Service
public class MealNameServiceImpl implements MealNameService{
    MealNameRepository mealNameRepository;

    public MealNameServiceImpl(MealNameRepository mealNameRepository) {
        this.mealNameRepository = mealNameRepository;
    }

    @Override
    public List<MealName> findAll() {
        return mealNameRepository.findAll();
    }
}

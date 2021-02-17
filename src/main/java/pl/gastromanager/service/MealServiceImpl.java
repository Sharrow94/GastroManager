package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Diet;
import pl.gastromanager.model.Ingredient;
import pl.gastromanager.model.IngredientsMeals;
import pl.gastromanager.model.Meal;
import pl.gastromanager.repository.DietRepository;
import pl.gastromanager.repository.IngredientsMealsRepository;
import pl.gastromanager.repository.MealRepository;
import pl.gastromanager.util.IngredientsMealsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final IngredientsMealsRepository ingredientsMealsRepository;
    private final DietRepository dietRepository;
    private List<Diet> diets;

    public MealServiceImpl(MealRepository mealRepository, IngredientsMealsRepository ingredientsMealsRepository, DietRepository dietRepository) {
        this.mealRepository = mealRepository;
        this.ingredientsMealsRepository = ingredientsMealsRepository;
        this.dietRepository = dietRepository;
        this.diets = dietRepository.findAll();
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

    @Override
    public void refreshMeal(Meal meal) {
        List<IngredientsMeals> ingredientsMealsList = ingredientsMealsRepository.findAllIngredientsByMeal(meal);
        List<Ingredient> ingredients = ingredientsMealsList.stream()
                .map(IngredientsMeals::getIngredient)
                .collect(Collectors.toList());

        //Setting meal properties
        boolean hasGluten = false;
        boolean hasLactose = false;
        boolean hasMeat = false;
        for (Ingredient ingredient : ingredients) {
            if(ingredient.isHasGluten()) meal.setHasGluten(true);
            if(ingredient.isHasLactose()) meal.setHasGluten(true);
            if(ingredient.isHasMeat()) meal.setHasGluten(true);
        }

        //Setting meal diet
        diets.forEach(diet->{
            if(diet.isHasGluten()==meal.isHasGluten() && diet.isHasLactose()==meal.isHasLactose() && diet.isHasMeat()==meal.isHasMeat()){
                meal.setDiet(diet);
            }
        });

        //Setting meal price
        float price = ingredientsMealsList.stream().map(IngredientsMeals::getPrice).reduce(Float::sum).orElse(0f);
        meal.setPrice(price);

        //Saving meal
        mealRepository.save(meal);
    }

    @Override
    public List<Ingredient> findAllMealIngredients(Meal meal) {
        List<IngredientsMeals> ingredientsMealsList = ingredientsMealsRepository.findAllIngredientsByMeal(meal);
        return ingredientsMealsList.stream().map(IngredientsMeals::getIngredient).collect(Collectors.toList());
    }

    @Override
    public void addIngredient(Meal meal, Ingredient ingredient, float quantity) {
        IngredientsMealsBuilder imBuilder = new IngredientsMealsBuilder();
        IngredientsMeals ingredientsMeals = imBuilder.meal(meal).ingredient(ingredient).quantity(quantity).build();
        ingredientsMealsRepository.save(ingredientsMeals);
    }

    @Override
    public void addManyIngredients(Meal meal, HashMap<Ingredient, Float> ingredientsQuantity) {
        ingredientsQuantity.forEach((key, value) -> addIngredient(meal, key, value));
    }
}

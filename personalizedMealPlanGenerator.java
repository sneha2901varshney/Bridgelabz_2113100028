package AssignmentGeneric;
import java.util.*;
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public List<String> getMeals() {
        return Arrays.asList("Vegetable Stir-Fry", "Lentil Soup", "Grilled Cheese");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public List<String> getMeals() {
        return Arrays.asList("Quinoa Salad", "Vegan Tacos", "Chickpea Curry");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public List<String> getMeals() {
        return Arrays.asList("Grilled Salmon", "Avocado Salad", "Bacon and Eggs");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public List<String> getMeals() {
        return Arrays.asList("Chicken Breast", "Protein Shake", "Egg White Omelette");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    @Override
    public String toString() {
        return "Meal Plan: " + mealPlan.getMealType() + "\nMeals: " + String.join(", ", mealPlan.getMeals());
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        return new Meal<>(mealPlan);
    }
}

public class personalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());

        System.out.println(vegetarianMeal);
        System.out.println("\n" + veganMeal);
        System.out.println("\n" + ketoMeal);
        System.out.println("\n" + highProteinMeal);
    }
}


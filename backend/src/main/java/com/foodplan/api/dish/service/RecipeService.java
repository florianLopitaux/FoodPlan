package com.foodplan.api.dish.service;

import com.foodplan.api.dish.dto.RecipeCreateDTO;
import com.foodplan.api.dish.exception.DishNotFoundException;
import com.foodplan.api.ingredient.exception.IngredientAlreadyPresentException;
import com.foodplan.api.dish.exception.RecipeNotFoundException;
import com.foodplan.api.dish.mapper.RecipeMapper;
import com.foodplan.api.dish.model.DishEntity;
import com.foodplan.api.dish.model.RecipeEntity;
import com.foodplan.api.dish.model.RecipeID;
import com.foodplan.api.dish.repository.DishRepository;
import com.foodplan.api.dish.repository.RecipeRepository;
import com.foodplan.api.ingredient.exception.IngredientNotFoundException;
import com.foodplan.api.ingredient.model.IngredientEntity;
import com.foodplan.api.ingredient.repository.IngredientRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RecipeService {
    // FIELDS
    private final RecipeRepository recipeRepository;
    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;


    // CONSTRUCTOR
    public RecipeService(RecipeRepository recipeRepository, DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }


    // SERVICE METHODS
    public Set<RecipeEntity> getDishRecipes(String dishName) throws DishNotFoundException {
        final Optional<DishEntity> foundDish = this.dishRepository.findById(dishName);

        if (foundDish.isEmpty()) {
            throw new DishNotFoundException(dishName);
        }

        return foundDish.get().getRecipes();
    }

    @Transactional
    public RecipeEntity addIngredient(String dishName, RecipeCreateDTO recipeCreateDTO)
            throws DishNotFoundException, IngredientNotFoundException, IngredientAlreadyPresentException {

        final Optional<DishEntity> foundDish = this.dishRepository.findById(dishName);
        final Optional<IngredientEntity> foundIngredient = this.ingredientRepository.findById(recipeCreateDTO.ingredientId());

        if (foundDish.isEmpty()) {
            throw new DishNotFoundException(dishName);

        } else if (foundIngredient.isEmpty()) {
            throw new IngredientNotFoundException(recipeCreateDTO.ingredientId());
        }

        final RecipeEntity recipe = RecipeMapper.toEntity(foundDish.get(), foundIngredient.get(), recipeCreateDTO);
        foundDish.get().addRecipeIngredient(recipe);
        this.recipeRepository.save(recipe);

        return recipe;
    }

    @Transactional
    public void deleteRecipe(String dishName, Long ingredientId) throws DishNotFoundException, RecipeNotFoundException {
        final Optional<DishEntity> foundDish = this.dishRepository.findById(dishName);

        if (foundDish.isEmpty()) {
            throw new DishNotFoundException(dishName);
        }

        if (!foundDish.get().deleteRecipeIngredient(ingredientId)) {
            throw new RecipeNotFoundException(dishName, ingredientId);
        }
        this.recipeRepository.deleteById(new RecipeID(dishName, ingredientId));
    }

    @Transactional
    public void deleteDishAllRecipes(String dishName) throws DishNotFoundException {
        final Optional<DishEntity> foundDish = this.dishRepository.findById(dishName);

        if (foundDish.isEmpty()) {
            throw new DishNotFoundException(dishName);
        }

        this.recipeRepository.deleteAll(foundDish.get().getRecipes());
        foundDish.get().clearRecipes();
    }
}

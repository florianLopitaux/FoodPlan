package com.foodplan.api.dish.controller;

import com.foodplan.api.dish.dto.DishCreateDTO;
import com.foodplan.api.dish.dto.DishOutputDTO;
import com.foodplan.api.dish.dto.RecipeCreateDTO;
import com.foodplan.api.dish.dto.RecipeOutputDTO;
import com.foodplan.api.dish.exception.DishAlreadyExistsException;
import com.foodplan.api.dish.exception.DishNotFoundException;
import com.foodplan.api.dish.exception.IngredientAlreadyPresentException;
import com.foodplan.api.dish.mapper.DishMapper;
import com.foodplan.api.dish.mapper.RecipeMapper;
import com.foodplan.api.dish.model.DishEntity;
import com.foodplan.api.dish.service.DishService;
import com.foodplan.api.dish.service.RecipeService;
import com.foodplan.api.ingredient.exception.IngredientNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(("/dishes"))
public class DishController {
    // FIELDS
    private final DishService dishService;
    private final RecipeService recipeService;


    // CONSTRUCTOR
    public DishController(DishService dishService, RecipeService recipeService) {
        this.dishService = dishService;
        this.recipeService = recipeService;
    }


    // ENDPOINTS GET REQUESTS
    @GetMapping
    public Set<DishOutputDTO> getAllDishes(@RequestParam(required = false) String nameFilter) {
        final Set<DishEntity> dishes;

        if (nameFilter == null) {
            dishes = this.dishService.getAllDishes();
        } else {
            dishes = this.dishService.getDishesByFilteredName(nameFilter);
        }

        return DishMapper.toOutputDTOs(dishes);
    }

    @GetMapping("/{dishName}")
    public DishOutputDTO getDishById(@PathVariable String dishName) throws DishNotFoundException {
        return DishMapper.toOutputDTO(this.dishService.getDish(dishName));
    }


    // ENDPOINTS POST REQUESTS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DishOutputDTO createDish(@RequestBody DishCreateDTO dishCreateDTO) throws DishAlreadyExistsException {
        return DishMapper.toOutputDTO(this.dishService.createDish(dishCreateDTO));
    }

    @PostMapping("/{dishName}/ingredients")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeOutputDTO createRecipe(@PathVariable String dishName, @RequestBody RecipeCreateDTO recipeCreateDTO)
            throws DishNotFoundException, IngredientNotFoundException, IngredientAlreadyPresentException {

        return RecipeMapper.toOutputDTO(this.recipeService.addIngredient(dishName, recipeCreateDTO));
    }


    // ENDPOINTS DELETE REQUESTS
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDishById(@RequestParam String dishName) throws DishNotFoundException {
        this.dishService.deleteDish(dishName);
    }
}

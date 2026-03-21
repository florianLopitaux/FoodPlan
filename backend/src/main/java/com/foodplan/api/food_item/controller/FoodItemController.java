package com.foodplan.api.food_item.controller;

import com.foodplan.api.food_item.dto.FoodItemCreateDTO;
import com.foodplan.api.food_item.dto.FoodItemOutputDTO;
import com.foodplan.api.food_item.exception.FoodItemAlreadyExistsException;
import com.foodplan.api.food_item.exception.FoodItemNotFoundException;
import com.foodplan.api.food_item.mapper.FoodItemMapper;
import com.foodplan.api.food_item.model.FoodItemEntity;
import com.foodplan.api.food_item.service.FoodItemService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/foods")
public class FoodItemController {
    // FIELDS
    private final FoodItemService foodService;


    // CONSTRUCTOR
    public FoodItemController(FoodItemService foodService) {
        this.foodService = foodService;
    }


    // ENDPOINTS GET METHODS
    @GetMapping
    public Set<FoodItemOutputDTO> getAllFoodItems(@RequestParam(required = false) String nameFilter) {
        final Set<FoodItemEntity> entities;

        if (nameFilter == null) {
            entities = this.foodService.getAllFoodItems();
        } else {
            entities = this.foodService.getFoodItemsByFilteredName(nameFilter);
        }

        return FoodItemMapper.toOutputDTOs(entities);
    }

    @GetMapping("/{id_food_item}")
    public FoodItemOutputDTO getFoodItemById(@PathVariable Long id_food_item) throws FoodItemNotFoundException {
        return FoodItemMapper.toOutputDTO(this.foodService.getFoodItem(id_food_item));
    }

    @GetMapping
    public FoodItemOutputDTO getFoodItemByName(@RequestParam String name) throws FoodItemNotFoundException {
        return FoodItemMapper.toOutputDTO(this.foodService.getFoodItem(name));
    }


    // ENDPOINTS POST METHODS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodItemOutputDTO createFoodItem(@RequestBody FoodItemCreateDTO dto) throws FoodItemAlreadyExistsException {
        return FoodItemMapper.toOutputDTO(this.foodService.createFoodItem(dto));
    }


    // ENDPOINTS DELETE METHODS
    @DeleteMapping("/{id_food_item}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFoodItem(@PathVariable Long id_food_item) throws FoodItemNotFoundException {
        this.foodService.deleteFoodItem(id_food_item);
    }
}

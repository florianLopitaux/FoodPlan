package com.foodplan.api.food_item.service;

import com.foodplan.api.food_item.exception.FoodItemAlreadyExistsException;
import com.foodplan.api.food_item.exception.FoodItemNotFoundException;
import com.foodplan.api.food_item.model.FoodItemEntity;
import com.foodplan.api.food_item.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FoodService {
    // FIELDS
    private final FoodRepository foodRepository;


    // CONSTRUCTOR
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    // SERVICE METHODS
    public Set<FoodItemEntity> getAllFoodItems() {
        return new HashSet<>(this.foodRepository.findAll());
    }

    public FoodItemEntity getFoodItem(Long id) throws FoodItemNotFoundException {
        final Optional<FoodItemEntity> foundEntity = this.foodRepository.findById(id);

        if (foundEntity.isPresent()) {
            return foundEntity.get();
        } else {
            throw new FoodItemNotFoundException(id);
        }
    }

    public FoodItemEntity getFoodItem(String name) throws FoodItemNotFoundException {
        final Optional<FoodItemEntity> foundEntity = this.foodRepository.findByName(name);

        if (foundEntity.isPresent()) {
            return foundEntity.get();
        } else {
            throw new FoodItemNotFoundException(name);
        }
    }

    public FoodItemEntity createFoodItem(FoodItemEntity foodItemEntity) throws FoodItemAlreadyExistsException {
        if (this.foodRepository.existsById(foodItemEntity.getId())) {
            throw new FoodItemAlreadyExistsException(foodItemEntity.getId());
        }

        return this.foodRepository.save(foodItemEntity);
    }

    public FoodItemEntity createFoodItem(String name) throws FoodItemAlreadyExistsException {
        final FoodItemEntity entity = new FoodItemEntity();
        entity.setName(name);

        return this.createFoodItem(entity);
    }

    public void deleteFoodItem(Long id) throws FoodItemNotFoundException {
        if (!this.foodRepository.existsById(id)) {
            throw new FoodItemNotFoundException(id);
        }

        this.foodRepository.deleteById(id);
    }
}

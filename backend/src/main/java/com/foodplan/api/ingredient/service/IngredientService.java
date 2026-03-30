package com.foodplan.api.food_item.service;

import com.foodplan.api.food_item.dto.FoodItemCreateDTO;
import com.foodplan.api.food_item.exception.FoodItemAlreadyExistsException;
import com.foodplan.api.food_item.exception.FoodItemNotFoundException;
import com.foodplan.api.food_item.mapper.FoodItemMapper;
import com.foodplan.api.food_item.model.FoodItemEntity;
import com.foodplan.api.food_item.repository.FoodItemRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FoodItemService {
    // FIELDS
    private final FoodItemRepository foodRepository;


    // CONSTRUCTOR
    public FoodItemService(FoodItemRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    // SERVICE METHODS
    public Set<FoodItemEntity> getAllFoodItems() {
        return new HashSet<>(this.foodRepository.findAll());
    }

    public Set<FoodItemEntity> getFoodItemsByFilteredName(String nameFilter) {
        return this.foodRepository.findByNameContainingIgnoreCase(nameFilter);
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

    public FoodItemEntity createFoodItem(FoodItemCreateDTO foodItemCreateDTO) throws FoodItemAlreadyExistsException {
        final FoodItemEntity foodItemEntity = FoodItemMapper.toEntity(foodItemCreateDTO);
        return this.createFoodItem(foodItemEntity);
    }

    public FoodItemEntity createFoodItem(FoodItemEntity foodItemEntity) throws FoodItemAlreadyExistsException {
        if (foodItemEntity == null) {
            throw new IllegalArgumentException("FoodItemEntity parameter cannot be null");
        }

        if (this.foodRepository.existsById(foodItemEntity.getId())) {
            throw new FoodItemAlreadyExistsException(foodItemEntity.getId());
        } else if (this.foodRepository.findByName(foodItemEntity.getName()).isPresent()) {
            throw new FoodItemAlreadyExistsException(foodItemEntity.getName());
        }

        return this.foodRepository.save(foodItemEntity);
    }

    public void deleteFoodItem(Long id) throws FoodItemNotFoundException {
        if (!this.foodRepository.existsById(id)) {
            throw new FoodItemNotFoundException(id);
        }

        this.foodRepository.deleteById(id);
    }
}

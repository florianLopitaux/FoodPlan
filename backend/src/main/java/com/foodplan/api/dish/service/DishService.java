package com.foodplan.api.dish.service;

import com.foodplan.api.dish.dto.DishCreateDTO;
import com.foodplan.api.dish.exception.DishAlreadyExistsException;
import com.foodplan.api.dish.exception.DishNotFoundException;
import com.foodplan.api.dish.mapper.DishMapper;
import com.foodplan.api.dish.model.DishEntity;
import com.foodplan.api.dish.repository.DishRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DishService {
    // FIELDS
    private final DishRepository dishRepository;


    // CONSTRUCTOR
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    // SERVICE METHODS
    public Set<DishEntity> getAllDishes() {
        return new HashSet<>(this.dishRepository.findAll());
    }

    public Set<DishEntity> getDishesByFilteredName(String nameFilter) {
        return this.dishRepository.findByNameContainingIgnoreCase(nameFilter);
    }

    public DishEntity getDish(String name) throws DishNotFoundException {
        final Optional<DishEntity> entityFound = this.dishRepository.findById(name);

        if (entityFound.isPresent()) {
            return entityFound.get();
        } else {
            throw new DishNotFoundException(name);
        }
    }

    public DishEntity createDish(DishCreateDTO dishCreateDTO) throws DishAlreadyExistsException {
        return this.createDish(DishMapper.toEntity(dishCreateDTO));
    }

    public DishEntity createDish(DishEntity dish) throws DishAlreadyExistsException {
        if (dish == null) {
            throw new IllegalArgumentException("DishEntity parameter cannot be null");
        }

        if (this.dishRepository.existsById(dish.getName())) {
            throw new DishAlreadyExistsException(dish.getName());
        }

        return this.dishRepository.save(dish);
    }

    public void deleteDish(String dishName) throws DishNotFoundException {
        if (!this.dishRepository.existsById(dishName)) {
            throw new DishNotFoundException(dishName);
        }

        this.dishRepository.deleteById(dishName);
    }
}

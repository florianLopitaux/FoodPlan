package com.foodplan.api.ingredient.service;

import com.foodplan.api.ingredient.dto.IngredientCreateDTO;
import com.foodplan.api.ingredient.exception.IngredientAlreadyExistsException;
import com.foodplan.api.ingredient.exception.IngredientNotFoundException;
import com.foodplan.api.ingredient.mapper.IngredientMapper;
import com.foodplan.api.ingredient.model.IngredientEntity;
import com.foodplan.api.ingredient.repository.IngredientRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class IngredientService {
    // FIELDS
    private final IngredientRepository ingredientRepository;


    // CONSTRUCTOR
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    // SERVICE METHODS
    public Set<IngredientEntity> getAllIngredients() {
        return new HashSet<>(this.ingredientRepository.findAll());
    }

    public Set<IngredientEntity> getIngredientsByFilteredName(String nameFilter) {
        return this.ingredientRepository.findByNameContainingIgnoreCase(nameFilter);
    }

    public IngredientEntity getIngredient(Long id) throws IngredientNotFoundException {
        final Optional<IngredientEntity> foundEntity = this.ingredientRepository.findById(id);

        if (foundEntity.isPresent()) {
            return foundEntity.get();
        } else {
            throw new IngredientNotFoundException(id);
        }
    }

    public IngredientEntity getIngredient(String name) throws IngredientNotFoundException {
        final Optional<IngredientEntity> foundEntity = this.ingredientRepository.findByName(name);

        if (foundEntity.isPresent()) {
            return foundEntity.get();
        } else {
            throw new IngredientNotFoundException(name);
        }
    }

    public IngredientEntity createIngredient(IngredientCreateDTO ingredientCreateDTO) throws IngredientAlreadyExistsException {
        final IngredientEntity ingredientEntity = IngredientMapper.toEntity(ingredientCreateDTO);
        return this.createIngredient(ingredientEntity);
    }

    public IngredientEntity createIngredient(IngredientEntity ingredientEntity) throws IngredientAlreadyExistsException {
        if (ingredientEntity == null) {
            throw new IllegalArgumentException("IngredientEntity parameter cannot be null");
        }

        if (this.ingredientRepository.existsById(ingredientEntity.getId())) {
            throw new IngredientAlreadyExistsException(ingredientEntity.getId());
        } else if (this.ingredientRepository.findByName(ingredientEntity.getName()).isPresent()) {
            throw new IngredientAlreadyExistsException(ingredientEntity.getName());
        }

        return this.ingredientRepository.save(ingredientEntity);
    }

    public void deleteIngredient(Long id) throws IngredientNotFoundException {
        if (!this.ingredientRepository.existsById(id)) {
            throw new IngredientNotFoundException(id);
        }

        this.ingredientRepository.deleteById(id);
    }
}

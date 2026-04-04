package com.foodplan.api.ingredient.controller;

import com.foodplan.api.ingredient.dto.IngredientCreateDTO;
import com.foodplan.api.ingredient.dto.IngredientOutputDTO;
import com.foodplan.api.ingredient.exception.IngredientAlreadyExistsException;
import com.foodplan.api.ingredient.exception.IngredientNotFoundException;
import com.foodplan.api.ingredient.mapper.IngredientMapper;
import com.foodplan.api.ingredient.model.IngredientEntity;
import com.foodplan.api.ingredient.service.IngredientService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    // FIELDS
    private final IngredientService ingredientService;


    // CONSTRUCTOR
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    // ENDPOINTS GET REQUESTS
    @GetMapping
    public Set<IngredientOutputDTO> getAllIngredients(@RequestParam(required = false) String nameFilter) {
        final Set<IngredientEntity> entities;

        if (nameFilter == null) {
            entities = this.ingredientService.getAllIngredients();
        } else {
            entities = this.ingredientService.getIngredientsByFilteredName(nameFilter);
        }

        return IngredientMapper.toOutputDTOs(entities);
    }

    @GetMapping
    public IngredientOutputDTO getIngredientByName(@RequestParam String name) throws IngredientNotFoundException {
        return IngredientMapper.toOutputDTO(this.ingredientService.getIngredient(name));
    }

    @GetMapping("/{ingredientId}")
    public IngredientOutputDTO getIngredientById(@PathVariable Long ingredientId) throws IngredientNotFoundException {
        return IngredientMapper.toOutputDTO(this.ingredientService.getIngredient(ingredientId));
    }


    // ENDPOINTS POST REQUESTS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngredientOutputDTO createIngredient(@Valid @RequestBody IngredientCreateDTO dto) throws IngredientAlreadyExistsException {
        return IngredientMapper.toOutputDTO(this.ingredientService.createIngredient(dto));
    }


    // ENDPOINTS DELETE REQUESTS
    @DeleteMapping("/{ingredientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@Valid @PathVariable Long ingredientId) throws IngredientNotFoundException {
        this.ingredientService.deleteIngredient(ingredientId);
    }
}

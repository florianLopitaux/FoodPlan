package com.foodplan.api.ingredient.controller;

import com.foodplan.api.ingredient.dto.IngredientCreateDTO;
import com.foodplan.api.ingredient.dto.IngredientOutputDTO;
import com.foodplan.api.ingredient.exception.IngredientAlreadyExistsException;
import com.foodplan.api.ingredient.exception.IngredientNotFoundException;
import com.foodplan.api.ingredient.mapper.IngredientMapper;
import com.foodplan.api.ingredient.model.IngredientEntity;
import com.foodplan.api.ingredient.service.IngredientService;

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

    @GetMapping("/{idIngredient}")
    public IngredientOutputDTO getIngredientById(@PathVariable Long idIngredient) throws IngredientNotFoundException {
        return IngredientMapper.toOutputDTO(this.ingredientService.getIngredient(idIngredient));
    }

    @GetMapping
    public IngredientOutputDTO getIngredientByName(@RequestParam String name) throws IngredientNotFoundException {
        return IngredientMapper.toOutputDTO(this.ingredientService.getIngredient(name));
    }


    // ENDPOINTS POST REQUESTS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngredientOutputDTO createIngredient(@RequestBody IngredientCreateDTO dto) throws IngredientAlreadyExistsException {
        return IngredientMapper.toOutputDTO(this.ingredientService.createIngredient(dto));
    }


    // ENDPOINTS DELETE REQUESTS
    @DeleteMapping("/{idIngredient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable Long idIngredient) throws IngredientNotFoundException {
        this.ingredientService.deleteIngredient(idIngredient);
    }
}

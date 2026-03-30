package com.foodplan.api.ingredient.dto;

import com.foodplan.api.ingredient.model.IngredientEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record IngredientCreateDTO(

        @NotBlank(message = "The Ingredient's name is mandatory")
        @Size(max = IngredientEntity.NAME_MAX_LENGTH, message = "The Ingredient's name must not exceed {max} characters, given value : {validatedValue}")
        String name,

        @Size(max = IngredientEntity.DESCRIPTION_MAX_LENGTH, message = "The description must not exceed {max} characters, given value : {validatedValue}")
        String description,

        String imageSource

) {

}

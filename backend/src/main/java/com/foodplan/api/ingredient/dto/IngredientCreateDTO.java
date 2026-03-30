package com.foodplan.api.food_item.dto;

import com.foodplan.api.food_item.model.FoodItemEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FoodItemCreateDTO(

        @NotBlank(message = "The FoodItem's name is mandatory")
        @Size(max = FoodItemEntity.NAME_MAX_LENGTH, message = "The FoodItem's name must not exceed {max} characters, given value : {validatedValue}")
        String name,

        @Size(max = FoodItemEntity.DESCRIPTION_MAX_LENGTH, message = "The description must not exceed {max} characters, given value : {validatedValue}")
        String description,

        String imageSource

) {

}

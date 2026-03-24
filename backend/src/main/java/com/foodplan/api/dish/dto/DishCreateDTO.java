package com.foodplan.api.dish.dto;

import com.foodplan.api.dish.model.DishEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DishCreateDTO(

        @NotBlank(message = "The dish name is mandatory")
        @Size(max = DishEntity.NAME_MAX_LENGTH, message = "The dish name must not exceed {max} characters, given value : {validatedValue}")
        String name,

        @Size(max = DishEntity.DESCRIPTION_MAX_LENGTH, message = "The description must not exceed {max} characters, given value : {validatedValue}")
        String description,

        Byte minimumPerWeek,

        Byte maximumPerWeek,

        String imageSource
) {

}

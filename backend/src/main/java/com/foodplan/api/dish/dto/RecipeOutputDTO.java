package com.foodplan.api.dish.dto;

import com.foodplan.api.dish.model.RecipeUnit;

public record RecipeOutputDTO(
        String dishName,

        Long ingredientId,

        String ingredientName,

        Integer quantity,

        RecipeUnit unit
) {

}

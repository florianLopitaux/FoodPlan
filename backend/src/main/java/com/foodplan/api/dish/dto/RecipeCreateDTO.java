package com.foodplan.api.dish.dto;

import com.foodplan.api.dish.model.RecipeUnit;
import jakarta.validation.constraints.NotNull;

public record RecipeCreateDTO(

        @NotNull
        Long ingredientId,

        @NotNull
        Integer quantity,

        RecipeUnit unit

) {

}

package com.foodplan.api.dish.mapper;

import com.foodplan.api.dish.dto.RecipeCreateDTO;
import com.foodplan.api.dish.dto.RecipeOutputDTO;
import com.foodplan.api.dish.model.DishEntity;
import com.foodplan.api.dish.model.RecipeEntity;
import com.foodplan.api.ingredient.model.IngredientEntity;

import java.util.HashSet;
import java.util.Set;

public class RecipeMapper {

    public static RecipeEntity toEntity(DishEntity dish, IngredientEntity ingredient, RecipeCreateDTO dto) {
        return new RecipeEntity(
                dish,
                ingredient,
                dto.quantity(),
                dto.unit()
        );
    }

    public static RecipeOutputDTO toOutputDTO(RecipeEntity recipe) {
        return new RecipeOutputDTO(
                recipe.getDishName(),
                recipe.getIngredientId(),
                recipe.getIngredient().getName(),
                recipe.getQuantity(),
                recipe.getUnit()
        );
    }

    public static Set<RecipeOutputDTO> toOutputDTOs(Set<RecipeEntity> recipes) {
        final Set<RecipeOutputDTO> dtos = new HashSet<>();

        for (final RecipeEntity currentEntity : recipes) {
            dtos.add(RecipeMapper.toOutputDTO(currentEntity));
        }

        return dtos;
    }
}

package com.foodplan.api.ingredient.mapper;

import com.foodplan.api.ingredient.dto.IngredientCreateDTO;
import com.foodplan.api.ingredient.dto.IngredientOutputDTO;
import com.foodplan.api.ingredient.model.IngredientEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IngredientMapper {

    public static IngredientEntity toEntity(IngredientCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        final IngredientEntity entity = new IngredientEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setImageSource(dto.imageSource());

        return entity;
    }

    public static IngredientOutputDTO toOutputDTO(IngredientEntity ingredientEntity) {
        return new IngredientOutputDTO(
                ingredientEntity.getId(),
                ingredientEntity.getName(),
                ingredientEntity.getDescription(),
                ingredientEntity.getImageSource()
        );
    }

    public static Set<IngredientOutputDTO> toOutputDTOs(Collection<IngredientEntity> ingredientEntities) {
        final Set<IngredientOutputDTO> dtos = new HashSet<>();

        for (final IngredientEntity currentEntity : ingredientEntities) {
            dtos.add(IngredientMapper.toOutputDTO(currentEntity));
        }

        return dtos;
    }
}

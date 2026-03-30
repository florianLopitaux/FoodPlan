package com.foodplan.api.food_item.mapper;

import com.foodplan.api.food_item.dto.FoodItemCreateDTO;
import com.foodplan.api.food_item.dto.FoodItemOutputDTO;
import com.foodplan.api.food_item.model.FoodItemEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FoodItemMapper {

    public static FoodItemEntity toEntity(FoodItemCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        final FoodItemEntity entity = new FoodItemEntity();
        entity.setName(dto.name());
        entity.setImageSource(dto.imageSource());

        return entity;
    }

    public static FoodItemOutputDTO toOutputDTO(FoodItemEntity foodItemEntity) {
        return new FoodItemOutputDTO(
                foodItemEntity.getId(),
                foodItemEntity.getName(),
                foodItemEntity.getDescription(),
                foodItemEntity.getImageSource()
        );
    }

    public static Set<FoodItemOutputDTO> toOutputDTOs(Collection<FoodItemEntity> foodItemEntities) {
        final Set<FoodItemOutputDTO> dtos = new HashSet<>();

        for (final FoodItemEntity currentEntity : foodItemEntities) {
            dtos.add(FoodItemMapper.toOutputDTO(currentEntity));
        }

        return dtos;
    }
}

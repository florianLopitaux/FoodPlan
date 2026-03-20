package com.foodplan.api.food_item.mapper;

import com.foodplan.api.food_item.dto.FoodItemCreateDTO;
import com.foodplan.api.food_item.dto.FoodItemOutputDTO;
import com.foodplan.api.food_item.model.FoodItemEntity;

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

    public FoodItemOutputDTO toOutputDTO(FoodItemEntity foodItemEntity) {
        return new FoodItemOutputDTO(
                foodItemEntity.getName(),
                foodItemEntity.getImageSource()
        );
    }
}

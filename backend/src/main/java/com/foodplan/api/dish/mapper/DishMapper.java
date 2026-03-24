package com.foodplan.api.dish.mapper;

import com.foodplan.api.dish.dto.DishCreateDTO;
import com.foodplan.api.dish.dto.DishOutputDTO;
import com.foodplan.api.dish.model.DishEntity;

public class DishMapper {

    public static DishEntity toEntity(DishCreateDTO dto) {
        return new DishEntity(
                dto.name(),
                dto.description(),
                dto.minimumPerWeek(),
                dto.maximumPerWeek(),
                dto.imageSource()
        );
    }

    public static DishOutputDTO toOutputDTO(DishEntity dishEntity) {
        return new DishOutputDTO(
                dishEntity.getName(),
                dishEntity.getDescription(),
                dishEntity.getMinimumPerWeek(),
                dishEntity.getMaximumPerWeek(),
                dishEntity.getImageSource()
        );
    }

}

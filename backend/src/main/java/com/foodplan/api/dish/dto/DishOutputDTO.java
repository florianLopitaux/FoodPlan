package com.foodplan.api.dish.dto;

public record DishOutputDTO(

        String name,

        String description,

        Byte minimumPerWeek,

        Byte maximumPerWeek,

        String imageSource
) {

}

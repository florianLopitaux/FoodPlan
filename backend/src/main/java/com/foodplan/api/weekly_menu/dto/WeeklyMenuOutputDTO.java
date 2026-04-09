package com.foodplan.api.weekly_menu.dto;

import com.foodplan.api.weekly_menu.model.MealPlanEntity;

import java.util.List;

public record WeeklyMenuOutputDTO(

        Long id,

        String name,

        String description,

        List<MealPlanEntity> meals
) {

}

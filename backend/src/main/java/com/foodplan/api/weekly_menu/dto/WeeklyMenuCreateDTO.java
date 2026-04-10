package com.foodplan.api.weekly_menu.dto;

import com.foodplan.api.weekly_menu.model.WeeklyMenuEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record WeeklyMenuCreateDTO(

        @NotBlank(message = "The name of the weekly menu is mandatory")
        @Size(max = WeeklyMenuEntity.NAME_MAX_LENGTH, message = "The weekly menu name must not exceed {max} characters, given value : {validatedValue}")
        String name,

        @Size(max = WeeklyMenuEntity.DESCRIPTION_MAX_LENGTH, message = "The weekly menu description must not exceed {max} characters, given value : {validatedValue}")
        String description,

        @NotNull(message = "The date of the weekly menu is mandatory")
        LocalDate weekDate

) {

}

package com.foodplan.api.weekly_menu.mapper;

import com.foodplan.api.weekly_menu.dto.WeeklyMenuCreateDTO;
import com.foodplan.api.weekly_menu.dto.WeeklyMenuOutputDTO;
import com.foodplan.api.weekly_menu.model.WeeklyMenuEntity;

import java.util.ArrayList;
import java.util.List;

public class WeeklyMenuMapper {

    public static WeeklyMenuEntity toEntity(WeeklyMenuCreateDTO weeklyMenuCreateDTO) {
        final WeeklyMenuEntity weeklyMenuEntity = new WeeklyMenuEntity();

        weeklyMenuEntity.setName(weeklyMenuCreateDTO.name());
        weeklyMenuEntity.setDescription(weeklyMenuCreateDTO.description());
        weeklyMenuEntity.setWeekStartDate(weeklyMenuCreateDTO.weekDate());

        return weeklyMenuEntity;
    }

    public static WeeklyMenuOutputDTO toOutputDTO(WeeklyMenuEntity weeklyMenuEntity) {
        return new WeeklyMenuOutputDTO(
                weeklyMenuEntity.getId(),
                weeklyMenuEntity.getName(),
                weeklyMenuEntity.getDescription(),
                weeklyMenuEntity.getMealPlans()
        );
    }

    public static List<WeeklyMenuOutputDTO> toOutputDTOs(List<WeeklyMenuEntity> weeklyMenuOutputDTOs) {
        final List<WeeklyMenuOutputDTO> dtos = new ArrayList<>();

        for (final WeeklyMenuEntity currentEntity : weeklyMenuOutputDTOs) {
            dtos.add(WeeklyMenuMapper.toOutputDTO(currentEntity));
        }

        return dtos;
    }

}

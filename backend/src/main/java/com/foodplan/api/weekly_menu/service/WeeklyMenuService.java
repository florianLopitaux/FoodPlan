package com.foodplan.api.weekly_menu.service;

import com.foodplan.api.weekly_menu.dto.WeeklyMenuCreateDTO;
import com.foodplan.api.weekly_menu.exception.WeeklyMenuAlreadyExistsException;
import com.foodplan.api.weekly_menu.exception.WeeklyMenuNotFoundException;
import com.foodplan.api.weekly_menu.mapper.WeeklyMenuMapper;
import com.foodplan.api.weekly_menu.model.WeeklyMenuEntity;
import com.foodplan.api.weekly_menu.repository.MealPlanRepository;
import com.foodplan.api.weekly_menu.repository.WeeklyMenuRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WeeklyMenuService {
    // FIELDS
    private final WeeklyMenuRepository weeklyMenuRepository;
    private final MealPlanRepository mealPlanRepository;


    // CONSTRUCTOR
    public WeeklyMenuService(WeeklyMenuRepository weeklyMenuRepository, MealPlanRepository mealPlanRepository) {
        this.weeklyMenuRepository = weeklyMenuRepository;
        this.mealPlanRepository = mealPlanRepository;
    }


    // SERVICE METHODS
    public List<WeeklyMenuEntity> getAllWeeklyMenus() {
        final List<WeeklyMenuEntity> weeklyMenus = weeklyMenuRepository.findAll();
        Collections.sort(weeklyMenus);

        return weeklyMenus;
    }

    public WeeklyMenuEntity getWeeklyMenuById(Long id) throws WeeklyMenuNotFoundException {
        final Optional<WeeklyMenuEntity> foundMenu = this.weeklyMenuRepository.findById(id);

        if (foundMenu.isEmpty()) {
            throw new WeeklyMenuNotFoundException(id);
        }

        return foundMenu.get();
    }

    public WeeklyMenuEntity getWeeklyMenuByName(String name) throws WeeklyMenuNotFoundException {
        final Optional<WeeklyMenuEntity> foundMenu = this.weeklyMenuRepository.findByName(name);

        if (foundMenu.isEmpty()) {
            throw new WeeklyMenuNotFoundException(name);
        }

        return foundMenu.get();
    }

    @Transactional
    public WeeklyMenuEntity createWeeklyMenu(WeeklyMenuCreateDTO weeklyMenuCreateDTO) throws WeeklyMenuAlreadyExistsException {
        return this.createWeeklyMenu(WeeklyMenuMapper.toEntity(weeklyMenuCreateDTO));
    }

    @Transactional
    public WeeklyMenuEntity createWeeklyMenu(WeeklyMenuEntity weeklyMenuEntity) throws WeeklyMenuAlreadyExistsException {
        if (weeklyMenuEntity == null) {
            throw new IllegalArgumentException("WeeklyMenuEntity cannot be null");
        }

        if (this.weeklyMenuRepository.existsById(weeklyMenuEntity.getId())) {
            throw new WeeklyMenuAlreadyExistsException(weeklyMenuEntity.getId());
        }

        return this.weeklyMenuRepository.save(weeklyMenuEntity);
    }

    @Transactional
    public void deleteWeeklyMenu(Long id) throws WeeklyMenuNotFoundException {
        if (!this.weeklyMenuRepository.existsById(id)) {
            throw new WeeklyMenuNotFoundException(id);
        }

        this.weeklyMenuRepository.deleteById(id);
    }
}

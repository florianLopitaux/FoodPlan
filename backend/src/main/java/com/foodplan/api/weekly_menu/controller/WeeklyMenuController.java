package com.foodplan.api.weekly_menu.controller;

import com.foodplan.api.weekly_menu.dto.WeeklyMenuOutputDTO;
import com.foodplan.api.weekly_menu.exception.WeeklyMenuNotFoundException;
import com.foodplan.api.weekly_menu.mapper.WeeklyMenuMapper;
import com.foodplan.api.weekly_menu.service.WeeklyMenuService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class WeeklyMenuController {
    // FIELDS
    private final WeeklyMenuService weeklyMenuService;


    // CONSTRUCTOR
    public WeeklyMenuController(WeeklyMenuService weeklyMenuService) {
        this.weeklyMenuService = weeklyMenuService;
    }


    // ENDPOINT METHODS
    @GetMapping
    public List<WeeklyMenuOutputDTO> getAllWeeklyMenus() {
        return WeeklyMenuMapper.toOutputDTOs(weeklyMenuService.getAllWeeklyMenus());
    }

    @GetMapping("/{weeklyMenuId}")
    public WeeklyMenuOutputDTO getWeeklyMenuById(@PathVariable Long weeklyMenuId) throws WeeklyMenuNotFoundException {
        return WeeklyMenuMapper.toOutputDTO(this.weeklyMenuService.getWeeklyMenuById(weeklyMenuId));
    }

    @GetMapping
    public WeeklyMenuOutputDTO getWeeklyMenuByName(@RequestParam String weeklyMenuName) throws WeeklyMenuNotFoundException {
        return WeeklyMenuMapper.toOutputDTO(this.weeklyMenuService.getWeeklyMenuByName(weeklyMenuName));
    }

    @DeleteMapping("{weeklyMenuId}")
    public void deleteWeeklyMenu(@PathVariable Long weeklyMenuId) throws WeeklyMenuNotFoundException {
        this.weeklyMenuService.deleteWeeklyMenu(weeklyMenuId);
    }
}

package com.foodplan.api.weekly_menu.controller;

import com.foodplan.api.weekly_menu.dto.WeeklyMenuCreateDTO;
import com.foodplan.api.weekly_menu.dto.WeeklyMenuOutputDTO;
import com.foodplan.api.weekly_menu.exception.WeeklyMenuAlreadyExistsException;
import com.foodplan.api.weekly_menu.exception.WeeklyMenuNotFoundException;
import com.foodplan.api.weekly_menu.mapper.WeeklyMenuMapper;
import com.foodplan.api.weekly_menu.service.WeeklyMenuService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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


    // ENDPOINT GET REQUESTS
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


    // ENDPOINTS POST REQUESTS
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeeklyMenuOutputDTO createWeeklyMenu(@Valid WeeklyMenuCreateDTO weeklyMenuCreateDTO) throws WeeklyMenuAlreadyExistsException {
        return WeeklyMenuMapper.toOutputDTO(this.weeklyMenuService.createWeeklyMenu(weeklyMenuCreateDTO));
    }


    // ENDPOINTS DELETE REQUESTS
    @DeleteMapping("{weeklyMenuId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWeeklyMenu(@PathVariable Long weeklyMenuId) throws WeeklyMenuNotFoundException {
        this.weeklyMenuService.deleteWeeklyMenu(weeklyMenuId);
    }
}

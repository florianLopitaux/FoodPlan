package com.foodplan.api.weekly_menu.model;

import com.foodplan.api.dish.model.DishEntity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "meal_plan")
public class MealPlanEntity {
    // FIELDS
    @EmbeddedId
    private MealPlanID mealPlanID;

    @ManyToOne
    @MapsId("weeklyMenuId")
    @JoinColumn(name = "weekly_menu_id")
    private WeeklyMenuEntity weeklyMenu;

    @ManyToOne
    @MapsId("dishName")
    @JoinColumn(name = "dish_name")
    private DishEntity dish;


    // CONSTRUCTORS
    public MealPlanEntity() {}

    public MealPlanEntity(WeeklyMenuEntity weeklyMenu, DishEntity dish, LocalDate weekDate, MealTime mealTime) {
        this.mealPlanID = new MealPlanID(weeklyMenu.getId(), dish.getName(), weekDate, mealTime);
        this.weeklyMenu = weeklyMenu;
        this.dish = dish;
    }


    // GETTERS & SETTERS
    public MealPlanID getMealPlanID() {
        return this.mealPlanID;
    }

    public WeeklyMenuEntity getWeeklyMenu() {
        return this.weeklyMenu;
    }

    public Long getWeeklyMenuId() {
        return this.weeklyMenu.getId();
    }

    public DishEntity getDish() {
        return this.dish;
    }

    public String getDishName() {
        return this.dish.getName();
    }

    public LocalDate getWeekDay() {
        return this.mealPlanID.getWeekDay();
    }

    public MealTime getMealTime() {
        return this.mealPlanID.getMealTime();
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("MealPlanEntity{");

        builder.append("mealPlanID=").append(this.mealPlanID)
                .append("weeklyMenu=").append(this.weeklyMenu)
                .append("dish=").append(this.dish)
                .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MealPlanEntity that)) return false;
        return this.mealPlanID != null && this.mealPlanID.equals(that.mealPlanID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.mealPlanID);
    }
}

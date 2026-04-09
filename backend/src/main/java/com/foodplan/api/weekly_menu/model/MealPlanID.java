package com.foodplan.api.weekly_menu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.DayOfWeek;
import java.util.Objects;

@Embeddable
public class MealPlanID {
    // FIELDS
    @Column(nullable = false)
    private Long weeklyMenuId;

    @Column(nullable = false)
    private String dishName;

    @Column(nullable = false)
    private DayOfWeek weekDay;

    @Column(nullable = false)
    private MealTime mealTime;


    // CONSTRUCTORS
    public MealPlanID() {}

    public MealPlanID(Long weeklyMenuId, String dishName, DayOfWeek weekDay, MealTime mealTime) {
        this.weeklyMenuId = weeklyMenuId;
        this.dishName = dishName;
        this.weekDay = weekDay;
        this.mealTime = mealTime;
    }


    // GETTERS & SETTERS
    public Long getWeeklyMenuId() {
        return this.weeklyMenuId;
    }

    public void setWeeklyMenuId(Long weeklyMenuId) {
        this.weeklyMenuId = weeklyMenuId;
    }

    public String getDishName() {
        return this.dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public DayOfWeek getWeekDay() {
        return this.weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }

    public MealTime getMealTime() {
        return this.mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("MealPlanID{");

        builder.append("weeklyMenuId=").append(this.weeklyMenuId)
                .append(", dishName='").append(this.dishName).append('\'')
                .append(", weekDay=").append(this.weekDay)
                .append(", mealTime=").append(this.mealTime)
                .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MealPlanID that)) return false;
        return this.weeklyMenuId != null && this.weeklyMenuId.equals(that.weeklyMenuId) &&
                this.dishName != null && this.dishName.equals(that.dishName) &&
                Objects.equals(this.weekDay, that.weekDay) &&
                Objects.equals(this.mealTime, that.mealTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.weeklyMenuId, this.dishName, this.weekDay, this.mealTime);
    }
}

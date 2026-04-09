package com.foodplan.api.weekly_menu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "weekly_menu")
public class WeeklyMenuEntity implements Comparable<WeeklyMenuEntity> {
    // FIELDS
    public static final int NAME_MAX_LENGTH = 100;
    public static final int DESCRIPTION_MAX_LENGTH = 255;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = WeeklyMenuEntity.NAME_MAX_LENGTH, nullable = false, unique = true)
    private String name;

    @Column(length = WeeklyMenuEntity.DESCRIPTION_MAX_LENGTH)
    private String description;

    @Column(nullable = false)
    private LocalDate weekStartDate;

    @OneToMany(mappedBy = "weeklyMenu", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<MealPlanEntity> mealPlans;


    // CONSTRUCTORS
    public WeeklyMenuEntity() {
        this.mealPlans = new ArrayList<>();
    }

    public WeeklyMenuEntity(Long id, String name, String description, LocalDate weekStartDate) {
        this();
        this.id = id;
        this.setName(name);
        this.setDescription(description);
        this.setWeekStartDate(weekStartDate);
    }


    // GETTERS & SETTERS
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && this.name.length() <= NAME_MAX_LENGTH) {
            this.name = name;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= DESCRIPTION_MAX_LENGTH) {
            this.description = description;
        }
    }

    public LocalDate getWeekStartDate() {
        return this.weekStartDate;
    }

    public void setWeekStartDate(LocalDate weekStartDate) {
        if (weekStartDate == null) {
            return;
        }

        this.weekStartDate = weekStartDate.with(DayOfWeek.MONDAY);
    }

    public List<MealPlanEntity> getMealPlans() {
        return Collections.unmodifiableList(this.mealPlans);
    }


    // OVERRIDE METHODS FROM Comparable INTERFACE
    @Override
    public int compareTo(@NotNull WeeklyMenuEntity other) {
        if (this.getWeekStartDate() == null && other.getWeekStartDate() == null) {
            return 0;

        } else if (this.getWeekStartDate() == null) {
            return -1; // switch -1/+1 return values to have null at the end of the List
        } else if (other.getWeekStartDate() == null) {
            return 1;
        }

        // sort by descending to have recent weekly menus first
        return other.getWeekStartDate().compareTo(this.getWeekStartDate());
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("WeeklyMenuEntity{");

        builder.append("id=").append(this.id)
                .append(", name='").append(this.name).append('\'')
                .append(", description='").append(this.description).append('\'')
                .append(", weekStartDate=").append(this.weekStartDate)
                .append(", mealPlans=").append(this.mealPlans)
                .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeeklyMenuEntity that)) return false;
        return this.id != null && this.id.equals(that.id) && this.name != null && this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}

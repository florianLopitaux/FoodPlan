package com.foodplan.api.dish.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class RecipeID {
    // FIELDS
    @Column(nullable = false)
    private String dishName;

    @Column(nullable = false)
    private Long idFoodItem;


    // CONSTRUCTORS
    public RecipeID() {}

    public RecipeID(String dishName, Long idFoodItem) {
        this.dishName = dishName;
        this.idFoodItem = idFoodItem;
    }


    // GETTERS & SETTERS
    public String getDishName() {
        return this.dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Long getFoodItemID() {
        return this.idFoodItem;
    }

    public void setFoodItemID(Long idFoodItem) {
        this.idFoodItem = idFoodItem;
    }


    // OVERRIDE METHODS FROM Object METHODS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("RecipeID{");

        builder.append("dishName='").append(this.dishName).append('\'')
                .append(", idFoodItem='").append(this.idFoodItem).append('\'')
                .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeID that)) return false;
        return Objects.equals(this.dishName, that.dishName) && Objects.equals(this.idFoodItem, that.idFoodItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.dishName, this.idFoodItem);
    }
}

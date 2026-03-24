package com.foodplan.api.dish.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "recipe")
public class RecipeEntity {
    // FIELDS
    @EmbeddedId
    private RecipeID recipeID;

    @Column(nullable = false)
    private Integer quantity;

    private RecipeUnit unit;


    // CONSTRUCTORS
    public RecipeEntity() {}

    public RecipeEntity(RecipeID recipeID, Integer quantity, RecipeUnit unit) {
        this.recipeID = recipeID;
        this.quantity = quantity;
        this.unit = unit;
    }


    // GETTERS & SETTERS
    public RecipeID getRecipeID() {
        return this.recipeID;
    }

    public void setRecipeID(RecipeID recipeID) {
        this.recipeID = recipeID;
    }

    public String getDishName() {
        return this.recipeID.getDishName();
    }

    public void setDishName(String dishName) {
        this.recipeID.setDishName(dishName);
    }

    public Long getFoodItemID() {
        return this.recipeID.getFoodItemID();
    }

    public void setFoodItemID(Long foodItemID) {
        this.recipeID.setFoodItemID(foodItemID);
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public RecipeUnit getUnit() {
        return this.unit;
    }

    public void setUnit(RecipeUnit unit) {
        this.unit = unit;
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuffer builder = new StringBuffer("RecipeEntity{");

        builder.append("recipeID=").append(this.recipeID)
                .append(", quantity=").append(this.quantity)
                .append(", unit=").append(this.unit)
                .append("}");

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeID that)) return false;
        return this.recipeID != null && this.recipeID.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.recipeID);
    }
}

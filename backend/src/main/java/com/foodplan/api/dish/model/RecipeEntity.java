package com.foodplan.api.dish.model;

import com.foodplan.api.ingredient.model.IngredientEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "recipe")
public class RecipeEntity {
    // FIELDS
    @EmbeddedId
    private RecipeID recipeID;

    @ManyToOne
    @MapsId("dishName")
    @JoinColumn(name = "dish_name")
    private DishEntity dish;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;

    @Column(nullable = false)
    private Integer quantity;

    private RecipeUnit unit;


    // CONSTRUCTORS
    public RecipeEntity() {
        this.recipeID = new RecipeID();
    }

    public RecipeEntity(DishEntity dish, IngredientEntity ingredient, Integer quantity, RecipeUnit unit) {
        this.recipeID = new RecipeID(dish.getName(), ingredient.getId());
        this.dish = dish;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }


    // GETTERS & SETTERS
    public RecipeID getRecipeID() {
        return this.recipeID;
    }

    public DishEntity getDish() {
        return this.dish;
    }

    public String getDishName() {
        return this.recipeID.getDishName();
    }

    public IngredientEntity getIngredient() {
        return this.ingredient;
    }

    public Long getIngredientId() {
        return this.recipeID.getIngredientId();
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
                .append(", dish=").append(this.dish)
                .append(", ingredient=").append(this.ingredient)
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

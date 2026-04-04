package com.foodplan.api.dish.model;

import com.foodplan.api.ingredient.exception.IngredientAlreadyPresentException;
import com.foodplan.api.ingredient.model.IngredientEntity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "dish")
public class DishEntity {
    // FIELDS
    public static final int NAME_MAX_LENGTH = 100;
    public static final int DESCRIPTION_MAX_LENGTH = 255;
    public static final byte DEFAULT_MIN_AMOUNT_PER_WEEK = 1;
    public static final byte DEFAULT_MAX_AMOUNT_PER_WEEK = 4;


    @Id
    @Column(length = DishEntity.NAME_MAX_LENGTH)
    private String name;

    @Column(length = DishEntity.DESCRIPTION_MAX_LENGTH)
    private String description;

    private Byte minimum;

    private Byte maximum;

    private String imageSource;

    @OneToMany(mappedBy = "dish")
    private final Set<RecipeEntity> recipes;


    // CONSTRUCTORS
    public DishEntity() {
        this.minimum = DishEntity.DEFAULT_MIN_AMOUNT_PER_WEEK;
        this.maximum = DishEntity.DEFAULT_MAX_AMOUNT_PER_WEEK;
        this.recipes = new HashSet<>();
    }

    public DishEntity(String name, String description, Byte minimum, Byte maximum, String imageSource) {
        this();

        if (name != null && name.length() <= DishEntity.NAME_MAX_LENGTH) {
            this.name = name;
        } else {
            throw  new IllegalArgumentException("name is null or has too many characters, maximum = " + DishEntity.NAME_MAX_LENGTH);
        }

        this.description = description;
        this.imageSource = imageSource;

        if (minimum != null) {
            this.minimum = minimum;
        }

        if (maximum != null) {
            this.maximum = maximum;
        }
    }


    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > DishEntity.DESCRIPTION_MAX_LENGTH) {
            return;
        }

        this.description = description;
    }

    public Byte getMinimumPerWeek() {
        return this.minimum;
    }

    public void setMinimumPerWeek(Byte minimum) {
        this.minimum = minimum;
    }

    public Byte getMaximumPerWeek() {
        return this.maximum;
    }

    public void setMaximumPerWeek(Byte maximum) {
        this.maximum = maximum;
    }

    public String getImageSource() {
        return this.imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Set<RecipeEntity> getRecipes() {
        return Collections.unmodifiableSet(this.recipes);
    }

    public RecipeEntity addRecipeIngredient(RecipeEntity recipe) throws IngredientAlreadyPresentException {
        if (!recipes.add(recipe)) {
            throw new IngredientAlreadyPresentException(this, recipe.getIngredient());
        }

        return recipe;
    }

    public RecipeEntity addRecipeIngredient(IngredientEntity ingredient, int quantity, RecipeUnit unit) throws IngredientAlreadyPresentException {
        final RecipeEntity recipe = new RecipeEntity(this, ingredient, quantity, unit);
        return this.addRecipeIngredient(recipe);
    }

    public boolean deleteRecipeIngredient(Long ingredientID) {
        final Iterator<RecipeEntity> it = this.recipes.iterator();

        while (it.hasNext()) {
            final RecipeEntity recipe = it.next();
            if (recipe.getIngredientId().equals(ingredientID)) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    public boolean deleteRecipeIngredient(RecipeEntity recipe) {
        return this.recipes.remove(recipe);
    }

    public void clearRecipes() {
        this.recipes.clear();
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("DishEntity{");

        builder.append("name='").append(this.name).append('\'')
                .append(", description='").append(this.description).append('\'')
                .append(", minimum=").append(this.minimum)
                .append(", maximum=").append(this.maximum)
                .append(", imageSource='").append(this.imageSource).append('\'')
                .append(", recipes=").append(this.recipes)
                .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishEntity that)) return false;
        return this.name != null && this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}

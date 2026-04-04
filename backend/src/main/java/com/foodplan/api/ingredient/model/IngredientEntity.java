package com.foodplan.api.ingredient.model;

import com.foodplan.api.dish.model.RecipeEntity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class IngredientEntity {
    // FIELDS
    public static final int NAME_MAX_LENGTH = 100;
    public static final int DESCRIPTION_MAX_LENGTH = 255;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = IngredientEntity.NAME_MAX_LENGTH, nullable = false, unique = true)
    private String name;

    @Column(length = IngredientEntity.DESCRIPTION_MAX_LENGTH)
    private String description;

    private String imageSource;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<RecipeEntity> recipes;


    // CONSTRUCTORS
    public IngredientEntity() {
        this.recipes = new HashSet<>();
    }

    public IngredientEntity(Long id, String name, String description, String imageSource) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageSource = imageSource;
    }


    // GETTERS & SETTERS
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && name.length() <= IngredientEntity.NAME_MAX_LENGTH) {
            this.name = name;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > IngredientEntity.DESCRIPTION_MAX_LENGTH) {
            return;
        }

        this.description = description;
    }

    public String getImageSource() {
        return this.imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Set<RecipeEntity> getRecipes() {
        return this.recipes;
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("IngredientEntity{");

        builder.append("id=").append(this.id)
                .append(", name='").append(this.name).append('\'')
                .append(", description='").append(this.description).append('\'')
                .append(", imageSource='").append(this.imageSource).append('\'')
                .append(", recipes=").append(this.recipes)
                .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientEntity that)) return false;
        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}

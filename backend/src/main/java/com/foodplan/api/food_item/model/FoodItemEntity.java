package com.foodplan.api.food_item.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "food_item")
public class FoodItemEntity {
    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    // CONSTRUCTORS
    public FoodItemEntity() {}

    public FoodItemEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    // GETTERS & SETTERS
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("FoodEntity{");

        builder.append("id=").append(id)
            .append(", name='").append(name).append('\'')
            .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FoodItemEntity that)) return false;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}

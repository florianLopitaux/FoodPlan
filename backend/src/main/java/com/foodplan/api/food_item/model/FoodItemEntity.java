package com.foodplan.api.food_item.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "food_item")
public class FoodItemEntity {
    // FIELDS
    public static final int NAME_MAX_LENGTH = 100;
    public static final int DESCRIPTION_MAX_LENGTH = 255;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = FoodItemEntity.NAME_MAX_LENGTH, nullable = false, unique = true)
    private String name;

    @Column(length = FoodItemEntity.DESCRIPTION_MAX_LENGTH)
    private String imageSource;


    // CONSTRUCTORS
    public FoodItemEntity() {}

    public FoodItemEntity(Long id, String name,  String imageSource) {
        this.id = id;
        this.name = name;
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
        this.name = name;
    }

    public String getImageSource() {
        return this.imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("FoodEntity{");

        builder.append("id=").append(this.id)
            .append(", name='").append(this.name).append('\'')
            .append(", imageSource='").append(this.imageSource).append('\'')
            .append('}');

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItemEntity that)) return false;
        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}

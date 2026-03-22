package com.foodplan.api.dish.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "dish")
public class DishEntity {
    // FIELDS
    public static final byte DEFAULT_MIN_AMOUNT_PER_WEEK = 1;
    public static final byte DEFAULT_MAX_AMOUNT_PER_WEEK = 4;


    @Id
    private String name;

    private String description;

    private String imageSource;

    private Byte minimum;

    private Byte maximum;


    // CONSTRUCTORS
    public DishEntity() {
        this.minimum = DishEntity.DEFAULT_MIN_AMOUNT_PER_WEEK;
        this.maximum = DishEntity.DEFAULT_MAX_AMOUNT_PER_WEEK;
    }

    public DishEntity(String name, String description, String imageSource, Byte minimum, Byte maximum) {
        this();
        this.name = name;
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
        this.description = description;
    }

    public String getImageSource() {
        return this.imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
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


    // OVERRIDE METHODS FROM Object CLASS
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("DishEntity{");

        builder.append("name='").append(this.name).append('\'')
            .append(", description='").append(this.description).append('\'')
            .append(", minimum=").append(this.minimum)
            .append(", maximum=").append(this.maximum)
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

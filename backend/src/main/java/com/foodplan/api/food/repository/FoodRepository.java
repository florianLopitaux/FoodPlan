package com.foodplan.api.food.repository;

import com.foodplan.api.food.model.FoodItemEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodItemEntity, Long> {

    Optional<FoodItemEntity> findByName(String name);

}

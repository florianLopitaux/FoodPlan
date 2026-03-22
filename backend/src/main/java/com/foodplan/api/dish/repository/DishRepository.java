package com.foodplan.api.dish.repository;

import com.foodplan.api.dish.model.DishEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, String> {

    Set<DishEntity> findByNameContainingIgnoreCase(String name);

}

package com.foodplan.api.dish.repository;

import com.foodplan.api.dish.model.DishEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, String> {

}

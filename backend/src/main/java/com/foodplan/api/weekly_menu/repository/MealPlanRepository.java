package com.foodplan.api.weekly_menu.repository;

import com.foodplan.api.weekly_menu.model.MealPlanEntity;
import com.foodplan.api.weekly_menu.model.MealPlanID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlanEntity, MealPlanID> {

}

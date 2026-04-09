package com.foodplan.api.weekly_menu.repository;

import com.foodplan.api.weekly_menu.model.WeeklyMenuEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeeklyMenuRepository extends JpaRepository<WeeklyMenuEntity, Long> {

    Optional<WeeklyMenuEntity> findByName(String name);
}

package com.AntoineTrem.NurseryManager.DAL.Repositories;

import com.AntoineTrem.NurseryManager.DAL.Entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Integer> {

    public List<Meal> findAllByBabyId(int babyId);
}

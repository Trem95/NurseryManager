package com.AntoineTrem.NurseryManager.Metier.Mapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Meal;
import com.AntoineTrem.NurseryManager.Metier.DTO.MealDTO;
import com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper.SmallBabyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class MealMapper implements Mapper<MealDTO, Meal> {

    @Autowired
    private SmallBabyMapper babyMapper;

    @Override
    public MealDTO toDTO(Meal meal) {
        if(meal == null) return null;

        MealDTO mealDTO = new MealDTO();

        mealDTO.setId(meal.getId());
        mealDTO.setBaby(babyMapper.toDTO(meal.getBaby()));
        mealDTO.setMealObs(meal.getMealObs());
        mealDTO.setTypeMeal(meal.getTypeMeal());
        mealDTO.setMealDate(meal.getMealDate());

        return mealDTO;
    }

    @Override
    public Meal toEntity(MealDTO mealDTO) {
        if (mealDTO == null) return null;

        Meal meal = new Meal();

        meal.setId(mealDTO.getId());
        meal.setBaby(babyMapper.toEntity(mealDTO.getBaby()));
        meal.setMealObs(mealDTO.getMealObs());
        meal.setTypeMeal(mealDTO.getTypeMeal());
        meal.setMealDate(mealDTO.getMealDate());

        return meal;

    }
}

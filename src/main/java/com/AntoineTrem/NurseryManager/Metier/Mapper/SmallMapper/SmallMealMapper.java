package com.AntoineTrem.NurseryManager.Metier.Mapper.SmallMapper;

import com.AntoineTrem.NurseryManager.DAL.Entities.Meal;
import com.AntoineTrem.NurseryManager.Metier.Mapper.Mapper;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallMealDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallMealMapper implements Mapper<SmallMealDTO, Meal> {

    @Override
    public SmallMealDTO toDTO(Meal meal) {
        if (meal == null) return null;

        SmallMealDTO smallMealDTO = new SmallMealDTO();

        smallMealDTO.setId(meal.getId());
        smallMealDTO.setBabyId(meal.getBaby().getId());
        smallMealDTO.setTypeMeal(meal.getTypeMeal());
        smallMealDTO.setMealObs(meal.getMealObs());
        smallMealDTO.setMealDate(meal.getMealDate());

        return smallMealDTO;
    }

    @Override
    public Meal toEntity(SmallMealDTO smallMealDTO) {
        return null;
    }
}

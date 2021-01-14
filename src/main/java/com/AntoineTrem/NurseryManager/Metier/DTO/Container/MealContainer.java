package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import com.AntoineTrem.NurseryManager.Metier.DTO.MealDTO;

import java.util.List;

public class MealContainer extends ElementsContainer<MealDTO>{

    public MealContainer(List<MealDTO> list, int count) {
        super(list, count);
    }
}

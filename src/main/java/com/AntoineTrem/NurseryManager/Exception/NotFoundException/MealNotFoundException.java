package com.AntoineTrem.NurseryManager.Exception.NotFoundException;

import com.AntoineTrem.NurseryManager.Metier.DTO.MealDTO;

public class MealNotFoundException extends ElementNotFoundException{

    private int index;

    public MealNotFoundException(int id) {
        super(id, MealDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

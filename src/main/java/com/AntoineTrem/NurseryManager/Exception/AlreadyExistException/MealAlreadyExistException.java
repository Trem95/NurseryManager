package com.AntoineTrem.NurseryManager.Exception.AlreadyExistException;

import com.AntoineTrem.NurseryManager.Metier.DTO.MealDTO;

public class MealAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public MealAlreadyExistException(int id) {
        super(id, MealDTO.class);
        this.index = id;
    }

    public int getIndex(){return index;}
}

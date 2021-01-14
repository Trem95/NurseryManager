package com.AntoineTrem.NurseryManager.Exception.AlreadyExistException;

import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;

public class BabyAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public BabyAlreadyExistException(int id) {
        super(id, BabyDTO.class);
        this.index = id;
    }

    public int getIndex(){return index;}
}

package com.AntoineTrem.NurseryManager.Exception.AlreadyExistException;

import com.AntoineTrem.NurseryManager.Metier.DTO.NapDTO;

public class NapAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public NapAlreadyExistException(int id) {
        super(id, NapDTO.class);
        this.index = id;
    }

    public int getIndex(){return index;}
}

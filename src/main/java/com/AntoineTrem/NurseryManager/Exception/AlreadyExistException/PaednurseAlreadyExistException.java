package com.AntoineTrem.NurseryManager.Exception.AlreadyExistException;

import com.AntoineTrem.NurseryManager.Metier.DTO.PaednurseDTO;

public class PaednurseAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public PaednurseAlreadyExistException(int id) {
        super(id, PaednurseDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

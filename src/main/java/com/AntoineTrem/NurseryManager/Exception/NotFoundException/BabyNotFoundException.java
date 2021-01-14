package com.AntoineTrem.NurseryManager.Exception.NotFoundException;

import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;

public class BabyNotFoundException extends ElementNotFoundException{

    private int index;

    public BabyNotFoundException(int id) {
        super(id, BabyDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

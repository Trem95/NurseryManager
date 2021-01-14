package com.AntoineTrem.NurseryManager.Exception.NotFoundException;

import com.AntoineTrem.NurseryManager.Metier.DTO.NapDTO;

public class NapNotFoundException extends ElementNotFoundException{

    private int index;

    public NapNotFoundException(int id) {
        super(id, NapDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

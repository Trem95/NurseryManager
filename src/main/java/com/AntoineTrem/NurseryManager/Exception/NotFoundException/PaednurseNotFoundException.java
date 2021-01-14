package com.AntoineTrem.NurseryManager.Exception.NotFoundException;

import com.AntoineTrem.NurseryManager.Metier.DTO.PaednurseDTO;

public class PaednurseNotFoundException extends ElementNotFoundException{

    private int index;

    public PaednurseNotFoundException(int id) {
        super(id, PaednurseDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

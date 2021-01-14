package com.AntoineTrem.NurseryManager.Exception.NotFoundException;

import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;

public class ObservationNotFoundException extends ElementNotFoundException{

    private int index;

    public ObservationNotFoundException(int id) {
        super(id, ObservationDTO.class);
        this.index = id;
    }

    public int getIndex(){
        return index;
    }
}

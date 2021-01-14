package com.AntoineTrem.NurseryManager.Exception.AlreadyExistException;

import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;

public class ObservationAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public ObservationAlreadyExistException(int id) {
        super(id, ObservationDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

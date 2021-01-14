package com.AntoineTrem.NurseryManager.Exception.AlreadyExistException;

import com.AntoineTrem.NurseryManager.Metier.DTO.TimesheetDTO;

public class TimesheetAlreadyExistException extends ElementAlreadyExistException{

    private int index;

    public TimesheetAlreadyExistException(int id) {
        super(id, TimesheetDTO.class);
        this.index = id;
    }

    public int getIndex(){return index;}
}

package com.AntoineTrem.NurseryManager.Exception.NotFoundException;

import com.AntoineTrem.NurseryManager.Metier.DTO.TimesheetDTO;

public class TimesheetNotFoundException extends ElementNotFoundException{

    private int index;

    public TimesheetNotFoundException(int id) {
        super(id, TimesheetDTO.class);
        this.index = id;
    }

    public int getIndex() {
        return index;
    }
}

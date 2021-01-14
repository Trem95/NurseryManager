package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import com.AntoineTrem.NurseryManager.Metier.DTO.TimesheetDTO;

import java.util.List;

public class TimesheetContainer extends ElementsContainer<TimesheetDTO>{

    public TimesheetContainer(List<TimesheetDTO> list, int count) {
        super(list, count);
    }
}

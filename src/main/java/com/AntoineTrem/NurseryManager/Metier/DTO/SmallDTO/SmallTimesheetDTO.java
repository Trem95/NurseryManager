package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallTimesheetDTO {

    private int id;
    private Date arrivalTime;
    private Date leaveTime;
    private int babyId;

}

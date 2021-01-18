package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallTimesheetDTO {

    private int id;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date timesheetDate;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date arrivalTime;
    @JsonFormat( pattern = "HH:mm")
    private Date leaveTime;
    private int babyId;

}

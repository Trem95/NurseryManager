package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallNapDTO {

    private int id;
    private Date napTimeBegin;
    private Date napTimeEnd;
    private  String napObs;
    private int babyId;
}

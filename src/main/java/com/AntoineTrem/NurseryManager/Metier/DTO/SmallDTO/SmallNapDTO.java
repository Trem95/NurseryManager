package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallNapDTO {

    private int id;
    @JsonFormat( pattern = "HH:mm")
    private Date napTimeBegin;
    @JsonFormat( pattern = "HH:mm")
    private Date napTimeEnd;
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date napDate;
    private  String napObs;
    private int babyId;
}
